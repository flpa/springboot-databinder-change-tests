package com.example.databindertestboot3_1_6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Value;

@RestController
@RequestMapping("/value")
public class DemoLombokValue {

   @Value
   static class Dto {

      String field;

      Nested nested;
   }


   @Value
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
