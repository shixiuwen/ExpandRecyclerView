package shixia.expandrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
        CarBean carBean = gson.fromJson(json, CarBean.class);

        List data = carBean.getData();

        rvTree = (RecyclerView) findViewById(R.id.rv_tree);

        rvTree.setLayoutManager(new LinearLayoutManager(this));
        rvTree.setAdapter(new RecyclerAdapter(this,data));
    }

    /**三级目录数据结构*/

    private String json = "{\n" +
            "    \"status\":\"200\",\n" +
            "    \"info\":\"successful\",\n" +
            "    \"data\":[\n" +
            "        {\n" +
            "            \"brand\":\"LEVEL_01_A\",\n" +
            "            \"child01\":[\n" +
            "                {\n" +
            "                    \"child01Brand\":\"LEVEL_02_A\",\n" +
            "                    \"child02\":[\n" +
            "                        \"LEVEL_03_A\",\n" +
            "                        \"LEVEL_03_B\",\n" +
            "                        \"LEVEL_03_C\",\n" +
            "                        \"LEVEL_03_D\"\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"child01Brand\":\"LEVEL_02_B\",\n" +
            "                    \"child02\":[\n" +
            "                        \"LEVEL_03_AA\",\n" +
            "                        \"LEVEL_03_BB\",\n" +
            "                        \"LEVEL_03_CC\",\n" +
            "                        \"LEVEL_03_DD\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"brand\":\"LEVEL_01_B\",\n" +
            "            \"child01\":[\n" +
            "                {\n" +
            "                    \"child01Brand\":\"LEVEL_02_AA\",\n" +
            "                    \"child02\":[\n" +
            "                        \"LEVEL_033_A\",\n" +
            "                        \"LEVEL_033_B\",\n" +
            "                        \"LEVEL_033_C\",\n" +
            "                        \"LEVEL_033_D\"\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"child01Brand\":\"LEVEL_02_BB\",\n" +
            "                    \"child02\":[\n" +
            "                        \"LEVEL_033_AA\",\n" +
            "                        \"LEVEL_033_BB\",\n" +
            "                        \"LEVEL_033_CC\",\n" +
            "                        \"LEVEL_033_DD\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"brand\":\"LEVEL_01_C\",\n" +
            "            \"child01\":[\n" +
            "                {\n" +
            "                    \"child01Brand\":\"LEVEL_02_AAA\",\n" +
            "                    \"child02\":[\n" +
            "                        \"LEVEL_0333_A\",\n" +
            "                        \"LEVEL_0333_B\",\n" +
            "                        \"LEVEL_0333_C\",\n" +
            "                        \"LEVEL_0333_D\"\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"child01Brand\":\"LEVEL_02_BBB\",\n" +
            "                    \"child02\":[\n" +
            "                        \"LEVEL_0333_AA\",\n" +
            "                        \"LEVEL_0333_BB\",\n" +
            "                        \"LEVEL_0333_CC\",\n" +
            "                        \"LEVEL_0333_DD\"\n" +
            "                    ]\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
