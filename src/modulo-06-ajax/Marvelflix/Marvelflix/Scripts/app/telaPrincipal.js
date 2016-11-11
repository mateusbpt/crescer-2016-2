class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos(self) {
    self.$btnSincronizar = $('#btn-sincronizar-com-marvel');
    self.$btnSincronizar.on('click', self.sincronizar.bind(self));
  }

  sincronizar() {
    let self = this;
    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=7ae597c1277cc37f2a4001139b3e2199&orderBy=-modified&limit=20';
    $.get(url).then((res) => {
      res.data.results.forEach(
        (heroiMarvel) => {
          let heroiASerCriado = {
            nome: heroiMarvel.name,
            urlThumbnail: `${heroiMarvel.thumbnail.path}.${heroiMarvel.thumbnail.extension}`
          }
          self.cadastrarNovoHeroi(heroiASerCriado)
        }
      )
    });
  }

  cadastrarNovoHeroi(heroi) {
    $.post('/api/herois', heroi).done((res) => {
      console.log('novo id', res.id);
    });
  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();
    
    $.get('/api/herois')
      .done(function(res) {
        let renderizar = marvelflix.render('.tela', 'tela-principal', {
          chars: res.map(function (item) {
            return {
              id: item.id,
              name: item.nome,
              thumbnail: item.urlThumbnail
            }
          })
        });
        //renderizar.then(self.registrarBindsEventos.bind(self));
        renderizar.then(() => {
          this.registrarBindsEventos(this);
        })
      }.bind(this));
  }
}
