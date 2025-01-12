package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ValidadorHorarioAntecedencia  implements ValidadorAgendamentoDeConsulta{


    public void validar (DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinuto = Duration.between(agora,dataConsulta).toMinutes();

        if(diferencaEmMinuto <30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência minima de 30 minutos");
        }
    }
}
