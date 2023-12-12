package com.example.databindertestboot3_2_0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plain-java")
public class DemoPlainJava {

   static class Dto {
      private String field;
      private Nested nested;

      public Dto(String field, Nested nested) {
         this.field = field;
         this.nested = nested;
      }

      public String getField() {
         return field;
      }

      public void setField(String field) {
         this.field = field;
      }

      public Nested getNested() {
         return nested;
      }

      public void setNested(Nested nested) {
         this.nested = nested;
      }
   }


   static class Nested {
      private String nestedField;

      public String getNestedField() {
         return nestedField;
      }

      public void setNestedField(String nestedField) {
         this.nestedField = nestedField;
      }
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
