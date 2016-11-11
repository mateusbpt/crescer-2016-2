class Herois{
    constructor(array){
        this.array = array;
    }

naoParticipouGuerraCivil(){
      let retorno = [];
        for(let i = 0; i < this.array.length; i++){
            let aux = this.array[i];
            let obj = aux.events.items;
            let participou = false;
       
       for(let j = 0; j < obj.length; j++){
            if(obj[j].name === 'Civil War'){
                participou = true;
        } 
    }
          if(!participou){
            retorno.push(aux);   
            }  
        }
        return retorno;
 }


 /* maisPublicado(){
      let retorno = this.array[0]['comics'];
        for(let i = 1; i < this.array.length; i++){      
            let aux = this.array[i];
            let obj = aux['comics'];
       
       for(let j = 0; j < obj.length; j++){
            if(obj[j].available > retorno[j].available){
                retorno.pop();
                retorno.push(aux);
        } 
    }
        return retorno;
 }

 } */


//Realizados na aula de reforço - ajustar os testes

notCivilWar(){
    return this.array.filter(heroi => heroi.events.items.
                        filter(n => n.name.includes("Civil War")).length === 0);
}

 mais_Publicado(){
     return this.array.sort((aux1, aux2) => aux2.comics.available-aux1.comics.available)[0];
 }

 mediaPaginas(){
     let paginas = this.array.map(heroi => heroi.comics.items.reduce((acum, comic) => acum + comic.pageCount, 0)).
                        reduce((acum, paginas) => acum+paginas);
     return paginas/this.array.length;
 }

seriesPorLongevidade(){
    let retorno = [];
    this.array.forEach(heroi => { retorno = retorno.concat(heroi.series.items)});
    let diferenca = serie => serie.endYear - serie.startYear;
    return retorno.sort((serie1,serie2) => diferenca(serie2) - diferenca(serie1));

}


comicMaisCara() {
   let todasComics = []
   this.array.forEach(heroi => { todasComics = todasComics.concat(heroi.comics.items);});
    let totalizarPrecos = comic => comic.prices.reduce((acc, objetoPreco) => acc + objetoPreco.price, 0);
    return todasComics.sort((comic1, comic2) => totalizarPrecos(comic2) - totalizarPrecos(comic1))[0]
 }
}

