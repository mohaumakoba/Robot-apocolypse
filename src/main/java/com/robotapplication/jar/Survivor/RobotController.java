package com.robotapplication.jar.Survivor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("robotCpu")

public class RobotController {
    @Value("${external.api.url}")

   private String apiUrl;

    @GetMapping("/robotList")

    public ResponseEntity<String> getRobotList() {

        WebClient webClient = WebClient.create();

        String result = webClient.get()

              .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();


       System.out.println("----------------");
       System.out.println(result);
       System.out.println("-----------");

       return ResponseEntity.ok()
                .header("Content-Type", "application/json")

               .body(result);

    }

}