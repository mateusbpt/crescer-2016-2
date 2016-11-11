class TelaPrincipal {

    constructor(seletor) {
        this.$elem = $(seletor);
        this.renderizarEstadoInicial();
    }

    registrarBindsEventos(self) {
        self.$btnSincronizar = $('#btn-sincronizar-com-marvel');
        self.$btnSincronizar.on('click', self.sincronizar.bind(self));
        self.$btnPaginaAntiga = $('#btn-pagina-anterior');
        self.$btnPaginaAntiga.on('click', self.obterPaginaAntiga.bind(self));
        self.$btnProximaPagina = $('#btn-proxima-pagina');
        self.$btnProximaPagina.on('click', self.obterProximaPagina.bind(self));
    }

    obterProximaPagina() {
        this.carregarERenderizarHerois(++this.paginaAtual);
    }

    obterPaginaAntiga() {
        this.carregarERenderizarHerois(--this.paginaAtual);
    }

    sincronizar() {
        let self = this;
        let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=5a6961c8b418b994dfb885fcc4bfe064&orderBy=-modified&limit=20';
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

    carregarERenderizarHerois(pagina) {
        return $.get('/api/herois', {
            pagina: pagina,
            tamanhoPagina: 5
        }).done(function (res) {
            this.renderizarHerois(res).then(() => {
                this.registrarBindsEventos(this);
            })
        }.bind(this));
    }

    renderizarHerois(heroisServidor) {
        return marvelflix.render('.tela', 'tela-principal', {
            chars: heroisServidor.map(function (item) {
                return {
                    id: item.id,
                    name: item.nome,
                    thumbnail: item.urlThumbnail
                }
            })
        });
    }

    renderizarEstadoInicial() {
        $('.tela-centralizada').removeClass('tela-centralizada');
        this.$elem.show();
        this.paginaAtual = 1;
        this.carregarERenderizarHerois(this.pagina);
    }
}
