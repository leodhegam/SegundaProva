package com.tads.segundaprova

import androidx.lifecycle.ViewModel

class CadastraFragmentViewModel:ViewModel() {
    var id:Long = 0
    var nome:String=""
    var email:String=""
    var cidade:String=""
    var anoNascimento:Int=0
    var cpf:Int=0
    var profissao:String=""
}