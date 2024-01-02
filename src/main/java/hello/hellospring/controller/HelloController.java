package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "이 값을 가져가서 hello.html 에 전달해라" +
                "이렇게 줄바꿈을 하면 알아서 넘어가냐?" +
                "이때 수정을 해준다면?" +
                "이걸 바꿨으니 이제 될까?" +
                "아직도?" +
                "이제 될거같은 느낌쓰?" +
                "아니 진짜 왜 안되는건데" +
                "이번엔 되냐? 진짜로??");

        return "hello"; // 에서 실행해라
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getname() {
            return name;
        }

    }
}
