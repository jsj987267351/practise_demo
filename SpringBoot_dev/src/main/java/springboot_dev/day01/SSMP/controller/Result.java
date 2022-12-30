package springboot_dev.day01.SSMP.controller;


import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Object data;
    private String message;

    public Result() {
    }

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Result(String message) {
        this.flag = false;
        this.message = message;
    }
}
