alter table medicos add ativo tinyint;
update medicos set ativo = 1;
--Devido a nossa tabela ja esta populado devemos considerar inicialmente que todos medicos ali cadastrado estão ativos

