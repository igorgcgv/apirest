package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

    @Autowired
    public void validar (DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() <7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() >18;

        if(domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw   new ValidacaoException("Consulta fora do horário de funcionamento da clinica");

        }
    }
}
