package com.example.recyclerviewmvvmretrofit.models
/* dentro da URL https://api.github.com/search/repositories?q=ny
        serão retirados dados do arquivo Json , iniciando pela lista de itens (abrir no navegador para
        melhor visualização.
 */
data class RecyclerList (val items : ArrayList<RecyclerData>)

/* criando uma classe data para resgatar os dados dentro da lista acima buscando sempre pelos ids

 */
data class RecyclerData (val name : String, val description : String, val owner: Owner)
data class Owner(val avatar_url: String)