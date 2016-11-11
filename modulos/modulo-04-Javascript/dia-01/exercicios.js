
/*Exercício 1*/ 
function gerarPiramide(num) {
    for (var i = 1, n = num; i <= n; i++) {
        console.log(Array(i+1).join('R$'));
    }
}

/*Exercício 2*/ 
function diglettDig() {
    for (var i = 1, n = 100; i <= n; i++) {
        if (i % 5 === 0 && i % 3 !== 0) {
            console.log('trio trio trio');
        } else if (i % 3 === 0) {
            console.log('Diglett dig');
        } else {
            console.log(i);
        }
    }

}

function diglettDig2() {
    for (let i = 1, n = 100; i <= n; i++) {
        let divisivel5 = i % 5 === 0;
        let divisivel3 = i % 3 === 0;
        if (divisivel5 && divisivel3) {
            console.log('Diglett dig, trio trio trio');
        } else if (divisivel5) {
            console.log('trio trio trio');
        } else if (divisivel3) {
            console.log('Diglett dig');
        } else {
            console.log(i);
        }
    }

}

/*Exercício 3*/ 
function find(array, funcao) {
    var retorno = [];
    if(typeof funcao === 'function'){
    for (var i = 0, n = array.length; i <= n; i++) {
      if (funcao(array[i])) {
            retorno.push(array[i]);
        }
       }   
       return retorno;
}
return array;    
}

var maiorIgualADois = function(elemento) {
  return elemento >= 2;
};

var maior = 'maior igual a 2';

/*Exercício 4*/ 
function subtrair(numero1){
  return function(numero2){
      return numero1-numero2;
    } 
}

/*Exercicio 5*/
function iguais(obj1, obj2){
    
    if(typeof obj1 === 'object' && typeof obj2 === 'object'){
        
       if(Object.keys(obj1).length !== Object.keys(obj2).length) {
           return false;
       }
       
        for(let prop in obj1) {
            let saoIguais = iguais(obj1[prop], obj2[prop]);
                if(!saoIguais) {
                    return false;
                }     
        }       
        return true;
    }

    return obj1===obj2;
}



/*Exercício 6*/ 


/*Exercício 7*/
var mesclar = function(obj1, obj2, recursiva=false){
    for(let prop in obj2){
        if(recursiva && typeof obj2[prop] === 'object'){
            mesclar(obj1[prop], obj2[prop]);
        }else{
            obj1[prop] = obj2[prop];
        }
    }
}
