/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 00080339271
 */
@Entity
public class historico {
@Id 
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Integer id;
private String Num1, Num2, Result, Operador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum1() {
        return Num1;
    }

    public void setNum1(String Num1) {
        this.Num1 = Num1;
    }

    public String getNum2() {
        return Num2;
    }

    public void setNum2(String Num2) {
        this.Num2 = Num2;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public String getOperador() {
        return Operador;
    }

    public void setOperador(String Operador) {
        this.Operador = Operador;
    }

}
