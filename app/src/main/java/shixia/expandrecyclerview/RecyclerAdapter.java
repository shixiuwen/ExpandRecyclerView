package shixia.expandrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ShiXiuwen on 2017/4/12.
 * <p>
 * Description:提供一个实现多级目录显示的思路，简单的利用RecyclerView的Adapter实
 * 现，好处是自带动画效果，还可以自定义
 */

public class RecyclerAdapter extends RecyclerView.Adapter {

    private static final int TYPE_LEVEL_ONE = 0x001;
    private static final int TYPE_LEVEL_TWO = 0x002;
    private static final int TYPE_LEVEL_THREE = 0x003;
    private static final String TAG = RecyclerAdapter.class.getSimpleName();

    private Context context;
    private List<Object> carBeanList;


    public RecyclerAdapter(Context context, List<Object> carBeanList) {
        this.context = context;
        this.carBeanList = carBeanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_LEVEL_ONE:
                return new LevelOneHolder(LayoutInflater.from(context).inflate(R.layout.item_tree_level_one, parent, false));
            case TYPE_LEVEL_TWO:
                return new LevelTwoHolder(LayoutInflater.from(context).inflate(R.layout.item_tree_level_two, parent, false));
            case TYPE_LEVEL_THREE:
                return new LevelThreeHolder(LayoutInflater.from(context).inflate(R.layout.item_tree_level_three, parent, false));
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_LEVEL_ONE) {
            ((LevelOneHolder) holder).tvLevelOne.setText(((CarBean.DataBean) carBeanList.get(position)).getBrand());
            ((LevelOneHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, holder.getAdapterPosition() + "");
                    CarBean.DataBean carBean = (CarBean.DataBean) carBeanList.get(holder.getAdapterPosition());
                    List<CarBean.DataBean.Child01Bean> child01 = carBean.getChild01();
                    if (carBean.isExpand) {
                        int count = child01.size();
                        carBean.isExpand = false;
                        //如果子目录开启的也关闭掉
                        for (int i = 0; i < child01.size(); i++) {
                            carBeanList.remove(child01.get(i));
                            CarBean.DataBean.Child01Bean child01Bean = child01.get(i);
                            if (child01Bean.isExpand) {
                                child01Bean.isExpand = false;
                                List<String> child02 = child01Bean.getChild02();
                                for (int i1 = 0; i1 < child02.size(); i1++) {
                                    carBeanList.remove(child02.get(i1));
                                }
                                count += child01Bean.getChild02().size();
                            }
                        }
                        notifyItemRangeRemoved(holder.getAdapterPosition() + 1, count);
                    } else {
                        carBean.isExpand = true;
                        for (int i = 0; i < child01.size(); i++) {
                            carBeanList.add(holder.getAdapterPosition() + 1, child01.get(i));
                        }
                        notifyItemRangeInserted(holder.getAdapterPosition() + 1, child01.size());
                    }
                }
            });
        } else if (holder.getItemViewType() == TYPE_LEVEL_TWO) {
            ((LevelTwoHolder) holder).tvLevelTwo.setText(((CarBean.DataBean.Child01Bean) carBeanList.get(position)).getChild01Brand());
            ((LevelTwoHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, holder.getAdapterPosition() + "");
                    CarBean.DataBean.Child01Bean carBeanChild = (CarBean.DataBean.Child01Bean) carBeanList.get(holder.getAdapterPosition());
                    List<String> childString = carBeanChild.getChild02();
                    if (carBeanChild.isExpand) {
                        carBeanChild.isExpand = false;
                        for (int i = 0; i < childString.size(); i++) {
                            carBeanList.remove(childString.get(i));
                        }
                        notifyItemRangeRemoved(holder.getAdapterPosition() + 1, childString.size());
                    } else {
                        carBeanChild.isExpand = true;
                        for (int i = 0; i < childString.size(); i++) {
                            carBeanList.add(holder.getAdapterPosition() + 1, childString.get(i));
                        }
                        notifyItemRangeInserted(holder.getAdapterPosition() + 1, childString.size());
                    }
                }
            });
        } else if (holder.getItemViewType() == TYPE_LEVEL_THREE) {
            ((LevelThreeHolder) holder).tvLevelThree.setText((String) carBeanList.get(position));
            ((LevelThreeHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "点击了：" + carBeanList.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return carBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (carBeanList.get(position) instanceof CarBean.DataBean) {
            return TYPE_LEVEL_ONE;
        } else if (carBeanList.get(position) instanceof CarBean.DataBean.Child01Bean) {
            return TYPE_LEVEL_TWO;
        } else if (carBeanList.get(position) instanceof String) {
            return TYPE_LEVEL_THREE;
        }
        return super.getItemViewType(position);
    }


    class LevelOneHolder extends RecyclerView.ViewHolder {

        TextView tvLevelOne;

        public LevelOneHolder(View itemView) {
            super(itemView);
            tvLevelOne = (TextView) itemView.findViewById(R.id.tv_level_one);
        }
    }

    class LevelTwoHolder extends RecyclerView.ViewHolder {

        TextView tvLevelTwo;

        public LevelTwoHolder(View itemView) {
            super(itemView);
            tvLevelTwo = (TextView) itemView.findViewById(R.id.tv_level_two);
        }
    }

    class LevelThreeHolder extends RecyclerView.ViewHolder {

        TextView tvLevelThree;

        public LevelThreeHolder(View itemView) {
            super(itemView);
            tvLevelThree = (TextView) itemView.findViewById(R.id.tv_level_three);
        }
    }

}
