/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author mateus.teixeira
 */
public class PessoaFactory {

    public void create() {

        final String ddl = "CREATE TABLE MATEUS_TEIXEIRA("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        try (
                final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement();) {
            statement.executeUpdate(ddl);

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public void insert(Pessoa p) {
        final String insert = "INSERT INTO MATEUS_TEIXEIRA("
                + "ID_PESSOA, NM_PESSOA ) "
                + "VALUES (?, ?)";

        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setLong(1, p.getIdPessoa());
            preparedStatement.setString(2, p.getNomePessoa());
            preparedStatement.executeUpdate();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public void delete(Pessoa p) {
        final String insert = "DELETE MATEUS_TEIXEIRA WHERE ID_PESSOA = ?";

        try (
                final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            preparedStatement.setLong(1, p.getIdPessoa());
            preparedStatement.executeUpdate();

        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void main(String[] args) {
        PessoaFactory p = new PessoaFactory();
        final Scanner scanner = new Scanner(System.in);
        System.out.println("DIGITE O NOME INSERIDO: ");
        String aux = scanner.nextLine();
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(12l);
        pessoa.setNomePessoa(aux);
        p.insert(pessoa);
    }
}
