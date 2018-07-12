package cn.ksdshpx.javase.enhance;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/12
 * Time: 15:51
 * Description:复杂枚举类
 */
public enum TrafficLamp {
    RED(30) {
        @Override
        public TrafficLamp nextLamp() {
            return GREEN;
        }
    },
    GREEN(50) {
        @Override
        public TrafficLamp nextLamp() {
            return YELLOW;
        }
    },
    YELLOW(8) {
        @Override
        public TrafficLamp nextLamp() {
            return RED;
        }
    };

    private int time;

    private TrafficLamp(int time) {
        this.time = time;
    }

    public abstract TrafficLamp nextLamp();
}
