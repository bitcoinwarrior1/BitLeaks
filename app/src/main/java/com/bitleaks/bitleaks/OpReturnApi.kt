package com.bitleaks.bitleaks
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

/**
 * Created by sangalli on 17/2/17.
 */

class OpReturnApi
{
    companion object {
        fun storeMessageOnBlockchain(txHash: String) {
            println("Hash to be stored on blockchain: " + txHash)
            //view the transactions on:
            // https://testnet.smartbit.com.au/address/mnoQEPQe1D7hy2mvByJZk7cQ2JCd64cawA
            val url = "https://op-return.herokuapp.com/v2/saveTxHashInBlockchain/" + txHash
            url.httpPost();
            //val (request, response, result) = url.httpPost().responseString()
            //println("Response from server:" + response + "Result: "
            //        + result + "Request: " + request)
        }
    }
}

