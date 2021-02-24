package com.example.recyclerviewta.model
/*
Criado um modelo de dados de uma classe com todos os seus atributos que serão geranciados para a recy
cler view , depois foi criado um email builder (class EmailBuilder) que é responsável por criar
modelos de e-mails que seria um item especifico da lista , depois foi criada uma função global
chamada de (email) que é o bloco DSL fazendo a construção de vários e-mails builders sendo no final
cada e-mail builder aplicará cada alteração colocada no email corpo (fakeEmails), após aplicar toda
alteração ele chamará o método build e este irá aplicar e instanciar todas as propriedades dentro do e-mail
e devolver o e-mail
 */

//CLASSE COM GETS E SETS E HASHCODES ICON PARA MANIPULAÇÃO
    data class Email (
     val user: String,
     val subject:String,
     val preview: String,
     val date: String,
     val stared: Boolean,
     val unread:Boolean,
     var selected: Boolean = false
)
// FORMATO BUILDER PARA GERAR ITENS
    class EmailBuilder
{
     var user: String = ""
     var subject:String = ""
     var preview: String = ""
     var date: String = ""
     var stared: Boolean = false
     var unread:Boolean = false

//MÉTODO BUILD PARA CRIAÇÃO DO OBJETO
    fun build():Email = Email(user ,subject ,preview ,date ,stared ,unread ,false)
}

/* FUNÇÃO RESPONSÁVEL POR PROVER OS EMAILS FUNÇÃO GLOBAL,ESPERA UM BLOCO DE CÓDIGOS
   PROVÉM E GERENCIA OBJETOS EMAILS
*/
    fun email(block: EmailBuilder.() -> Unit): Email = EmailBuilder().apply(block).build()

// GERANDO EMAILS EM UMA LISTA MUTÁVEL
    fun fakeEmails(): MutableList<Email> = mutableListOf(

        //Objetos itens.
        email {
            user = "Facebook"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Twitter"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Instagram"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Linkedin"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Telegram"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
                email {
            user = "Facebook"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Twitter"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Instagram"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Linkedin"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Telegram"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Facebook"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Twitter"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Instagram"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Linkedin"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        },
        email {
            user = "Telegram"
            subject = "Dicas principais para sua sorte"
            preview = "Olá filho da mãe vai estudar"
            date = "23 de jun"
            stared = false
        }
    )