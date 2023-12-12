package com.example.databindertestboot3_2_0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Builder;
import lombok.Data;

@RestController
@RequestMapping("/builder")
public class DemoLombokDataBuilder {

   @Data
   @Builder
   static class Dto {

      String field;

      Nested nested;
   }


   @Data
   static class Nested {

      String nestedField;
   }


   @GetMapping
   public String demo(Dto dto) {
      String result = dto.getField();

      if (dto.getNested() != null)
         result += dto.getNested().getNestedField();
      else
         result += ", nested is empty";

      return result;
   }
}
