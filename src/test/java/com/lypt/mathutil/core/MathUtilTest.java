/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.lypt.mathutil.core;

import static com.lypt.mathutil.junit5.core.MathUntil.getFactorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


/**
 *
 * @author THUY PHUNG
 */
public class MathUtilTest {
    //DDT : tách data ra khỏi câu lệnh, tham số hóa data
    //chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][]{
            {1,1},
            {2,2},
            {5,120},
            {6,120}               
        };
    }
    @ParameterizedTest
    @MethodSource(value = "initData") //initData: tên hàm cung cấp data, ngầm định thứ tự của các phần tử mảng, map vào tham số hàm
      public void testGetFactorialGivenRightArgReturnWell(int input, long expected){
        // import static nên không cần gọi qua lớp: Assert.assertEquals, MathUntil.getFactorial(4)
        assertEquals(expected, getFactorial(input));
    }
    
//      @Test 
//      public void testGetFactorialGivenRightArgReturnWell(){
//        // import static nên không cần gọi qua lớp: Assert.assertEquals, MathUntil.getFactorial(4)
//        
//        assertEquals(120, getFactorial(5));
//    }
      //Bắt ngoại lệ
      //@Test(expected = tenngoaile.class) => JUnit4 
      @Test
      public void testGetFactorialGivenWrongArgThrowException(){
          //dùng biểu thức lamda
          //functional interface tên là Executable - có 1 hàm duy nhất không code
         //tên là execute()
   /*      Executable exObject = new Executable() {
             @Override
             public void execute() throws Throwable {
                 getFactorial(-5);
             }
         };
    */
      //  Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
      }
   
}
