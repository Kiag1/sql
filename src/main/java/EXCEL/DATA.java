package EXCEL;

public class DATA {
    String name;
    String xueyuan;
    String sno;
    String now_time;
    int time;

    public DATA() {
    }

    @Override
    public String toString() {
        return "数据：[" +
                "姓名='" + name + '\'' +
                ", 学院='" + xueyuan + '\'' +
                ", 学号='" + sno + '\'' +
                ", 查询时间='" + now_time + '\'' +
                ", 志愿时长=" + time +
                ']';
    }

    public DATA(String name, String xueyuan, String sno, String now_time, int time) {
        this.name = name;
        this.xueyuan = xueyuan;
        this.sno = sno;
        this.now_time = now_time;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getNow_time() {
        return now_time;
    }

    public void setNow_time(String now_time) {
        this.now_time = now_time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public String[] getMessage() {
        String[] message = new String[5];
        message[0] = this.name;
        message[1] = this.xueyuan;
        message[2] = this.sno;
        message[3] = this.now_time;
        message[4] = String.valueOf(this.time);
        return message;
    }
}
