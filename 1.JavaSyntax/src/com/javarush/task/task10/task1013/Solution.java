package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String field1;
        private Integer field2;
        private Long field3;
        private Boolean field4;
        private Short field5;
        private Character field6;

        public Human(String field1) {
            this.field1 = field1;
        }

        public Human(Long field3, Boolean field4, Short field5) {
            this.field3 = field3;
            this.field4 = field4;
            this.field5 = field5;
        }

        public Human(String field1, Integer field2, Long field3, Boolean field4, Short field5, Character field6) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
            this.field4 = field4;
            this.field5 = field5;
            this.field6 = field6;
        }

        public Human(String field1, Integer field2, Long field3) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }

        public Human(Character field6) {
            this.field6 = field6;
        }

        public Human(Short field5) {
            this.field5 = field5;
        }

        public Human(Boolean field4) {
            this.field4 = field4;
        }

        public Human(Long field3) {
            this.field3 = field3;
        }

        public Human(Long field3, Boolean field4, Short field5, Character field6) {
            this.field3 = field3;
            this.field4 = field4;
            this.field5 = field5;
            this.field6 = field6;
        }

        public Human(Integer field2) {
            this.field2 = field2;
        }
    }
}
