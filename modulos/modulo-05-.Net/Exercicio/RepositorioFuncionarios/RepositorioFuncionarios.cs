using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var retorno = Funcionarios.Where(funcionario =>
                    funcionario.Cargo.Titulo.Contains(cargo.Titulo)).ToList();
            return retorno;
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            var retorno = Funcionarios.OrderBy(funcionario => funcionario.Nome).
                            OrderBy(cargo => cargo.Cargo.Titulo).ToList();
            return retorno;
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var retorno = Funcionarios.Where(funcionario =>
                                funcionario.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) != -1).ToList();
            return retorno;
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            var retorno = Funcionarios;

            if (turnos.Length > 0)
            {
                retorno = Funcionarios.Where(funcionario =>
                     turnos.Contains(funcionario.TurnoTrabalho)).ToList();

            }

            return retorno;
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            //Falta Implementar
            throw new NotImplementedException();
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            var retorno = 0.0;

            if (turno != null)
            {
                var auxiliar = Funcionarios.Where(funcionario =>
                     funcionario.TurnoTrabalho == turno).ToList();

                retorno = auxiliar.Sum(funcionario => funcionario.Cargo.Salario) / auxiliar.Count;
            }
            else
            {
                retorno = Funcionarios.Sum(funcionario => funcionario.Cargo.Salario) / Funcionarios.Count;
            }
            return retorno;
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var retorno = Funcionarios.Where(funcionario =>
                        funcionario.DataNascimento.Month.Equals(DateTime.Now.Month)).ToList();

            return retorno;
        }

        public IList<dynamic> BuscaRapida()
        {
            var retorno = new List<dynamic>();

            var listaSimplificada = Funcionarios.Select(funcionario => new
            {
                NomeFuncionario = funcionario.Nome,
                TituloCargo = funcionario.Cargo.Titulo
            }).ToList();

            foreach (var funcionario in listaSimplificada)
            {
                retorno.Add(funcionario);
            }

            return retorno;
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            var retorno = new List<dynamic>();

            var funcionariosPorTurno = Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho).
                Select(quantidadeCargo => new
                {
                    Turno = quantidadeCargo.Key,
                    Quantidade = quantidadeCargo.Count()
                }).ToList();

            foreach (var cargo in funcionariosPorTurno)
            {
                retorno.Add(cargo);
            }

            return retorno;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var listaVogais = new List<string> { "a", "e", "i", "o", "u" };
            var funcionarioComplexo = Funcionarios.Where(funcionario => funcionario.TurnoTrabalho != TurnoTrabalho.Tarde
                        && !funcionario.Cargo.Titulo.Equals("Desenvolvedor Júnior")).
                        OrderBy(consoante => !listaVogais.Contains(consoante.ToString().ToLower())).Last();

            var cargoFuncionarioComplexo = Funcionarios.Where(funcionario =>
                        funcionario.Cargo.Equals(funcionarioComplexo.Cargo)).Count();

            return new
            {   //Falta ajustar para estilo de moeda
                Nome = funcionarioComplexo.Nome,
                DataNascimento = $"{funcionarioComplexo.DataNascimento.Day}/{funcionarioComplexo.DataNascimento.Month}/{funcionarioComplexo.DataNascimento.Year}",
                SalarioRS = $"{funcionarioComplexo.Cargo.Salario}",
                SalarioUS = $"{funcionarioComplexo.Cargo.Salario}",
                QuantidadeMesmoCargo = cargoFuncionarioComplexo
            };
        }

    }
}