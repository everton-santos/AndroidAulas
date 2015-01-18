package com.android.josias.storage.sqlite;

/**
 * Created by Josias on 18/01/2015.
 */
public class Aluno {
        private String cod;
        private String matricula;
        private String nome;

        public Aluno() {
        }

        public Aluno(String matricula, String nome) {
            this.matricula = matricula;
            this.nome = nome;
        }

        public String getCod() {
            return cod;
        }

        public void setCod(String cod) {
            this.cod = cod;
        }
        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }

