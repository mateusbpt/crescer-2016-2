/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.Connection;
/**
 *
 * @author mateus.teixeira
 */
public class Run {

    public static void main(String[] args) {

        try (final Connection connection = ConnectionUtils.getConnection()) {
            if (!connection.isClosed()) {
                System.out.println("OK!");
            }
        } catch (Exception e) {
        }
    }
}
