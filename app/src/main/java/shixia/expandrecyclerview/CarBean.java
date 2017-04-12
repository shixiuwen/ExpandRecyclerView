package shixia.expandrecyclerview;

import java.util.List;

/**
 * Created by ShiXiuwen on 2017/4/12.
 * Description:
 */

public class CarBean {
    /**
     * status : 200
     * info : successful
     * data : [{"brand":"LEVEL_01_A","child01":[{"child01Brand":"LEVEL_02_A","child02":["LEVEL_03_A","LEVEL_03_B","LEVEL_03_C","LEVEL_03_D"]},{"child01Brand":"LEVEL_02_B","child02":["LEVEL_03_AA","LEVEL_03_BB","LEVEL_03_CC","LEVEL_03_DD"]}]},{"brand":"LEVEL_01_B","child01":[{"child01Brand":"LEVEL_02_A","child02":["LEVEL_03_A","LEVEL_03_B","LEVEL_03_C","LEVEL_03_D"]},{"child01Brand":"LEVEL_02_B","child02":["LEVEL_03_AA","LEVEL_03_BB","LEVEL_03_CC","LEVEL_03_DD"]}]},{"brand":"LEVEL_01_C","child01":[{"child01Brand":"LEVEL_02_A","child02":["LEVEL_03_A","LEVEL_03_B","LEVEL_03_C","LEVEL_03_D"]},{"child01Brand":"LEVEL_02_B","child02":["LEVEL_03_AA","LEVEL_03_BB","LEVEL_03_CC","LEVEL_03_DD"]}]}]
     *
     */

    private String status;
    private String info;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * brand : LEVEL_01_A
         * child01 : [{"child01Brand":"LEVEL_02_A","child02":["LEVEL_03_A","LEVEL_03_B","LEVEL_03_C","LEVEL_03_D"]},{"child01Brand":"LEVEL_02_B","child02":["LEVEL_03_AA","LEVEL_03_BB","LEVEL_03_CC","LEVEL_03_DD"]}]
         */

        private String brand;
        private List<Child01Bean> child01;

        public boolean isExpand;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public List<Child01Bean> getChild01() {
            return child01;
        }

        public void setChild01(List<Child01Bean> child01) {
            this.child01 = child01;
        }

        public static class Child01Bean {
            /**
             * child01Brand : LEVEL_02_A
             * child02 : ["LEVEL_03_A","LEVEL_03_B","LEVEL_03_C","LEVEL_03_D"]
             */

            private String child01Brand;
            private List<String> child02;

            public boolean isExpand;

            public String getChild01Brand() {
                return child01Brand;
            }

            public void setChild01Brand(String child01Brand) {
                this.child01Brand = child01Brand;
            }

            public List<String> getChild02() {
                return child02;
            }

            public void setChild02(List<String> child02) {
                this.child02 = child02;
            }
        }
    }
}
