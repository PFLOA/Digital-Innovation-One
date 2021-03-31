#!/bin/sh

GREEN='\033[2;92m'
RED='\033[0;31m'
BLUE='\033[24;34m'
bold=$(tput bold)
normal=$(tput sgr0)

globalTituloAtendimentoJira=""
globalNumeroAtendimento=""
globalNumeroVersaoSistema=""
COMANDO=$1
texto=""

cabecalhoScript() {
    echo -e ""
    echo -e "Opções disponíveis: \n"
    printf "${BLUE}${bold}init${normal}\t=> Cria uma nova branch com um argumento para o ${RED}${BOLD}<numero do atendimento>.${normal}
           Pega as alterações da branch development pra manter a nova branch com uma cópia do codigo atualizado.
           Puxa as alterações pra branch atual q é a do atendimento.Gera o commit com argumento ${RED}${BOLD}<título do atendimento, pegar no jira>${normal}.
           Gera uma tag para o commit no bitbucket com argumento ${RED}${BOLD}<numero da versão do sistema, no jira (ex: 2.3.15)>${normal}\n\n"
}

commit() {

    echo -e "Insira o ${RED}${BOLD}<título do atendimento, pegar no jira>${normal}."
    read tituloAtendimentoJira
    globalTituloAtendimentoJira=$tituloAtendimentoJira

    texto="\ngit commit -m QUALISPHP-$globalNumeroAtendimento - $globalTituloAtendimentoJira \ngit push\n"

    git commit -m "QUALISPHP-$globalNumeroAtendimento - $globalTituloAtendimentoJira"
    git push

    echo -e $texto
    tag
}

tag() {

    echo -e "Insira o ${RED}${BOLD}<numero da versão do sistema, no jira (ex: 2.3.15)>${normal}"
    read numeroVersaoSistema
    globalNumeroVersaoSistema=$numeroVersaoSistema

    echo -e "Insira o número da ${RED}${BOLD}<versão do atendimento>${normal}"
    read numeroVersaoAtendimento

    texto="\ngit tag $globalNumeroVersaoSistema-$globalNumeroAtendimento.$numeroVersaoAtendimento\nFim do processo de Versionamento\n"

    git tag $globalNumeroVersaoSistema-$globalNumeroAtendimento.$numeroVersaoAtendimento
    git push origin $globalNumeroVersaoSistema-$globalNumeroAtendimento.$numeroVersaoAtendimento
    
    echo -e $texto
}

init() {

    echo -e "Insira o ${RED}${BOLD}<numero do atendimento>.${normal}."
    read numeroAtendimento
    globalNumeroAtendimento=$numeroAtendimento

    texto="\ngit checkout -b qualisphp-$numeroAtendimento\ngit checkout development\ngit pull\ngit checkout qualisphp-$numeroAtendimento\ngit merge development\ngit add"

    git checkout -b qualisphp-$numeroAtendimento
    git checkout development
    git checkout qualisphp-$numeroAtendimento
    git merge development
    git add .

    echo -e $texto

    commit
}

if [ -z $COMANDO ]; then
    cabecalhoScript
fi

if [[ $COMANDO == "init" ]]; then
    init
    exit 0
fi
