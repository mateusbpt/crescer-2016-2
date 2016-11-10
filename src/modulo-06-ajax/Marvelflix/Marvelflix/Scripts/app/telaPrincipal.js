class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.registrarBindsEventos();
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos() {
  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();  
   
    marvelflix.render('.tela', 'tela-principal', {
      chars: [
        { id: 1, name: 'Iron Man', thumbnail: 'https://cloud.githubusercontent.com/assets/526075/20180159/652c5846-a740-11e6-8b56-19256fcc52c3.png' },
        { id: 2, name: 'Spider Man', thumbnail: 'https://cloud.githubusercontent.com/assets/526075/20180159/652c5846-a740-11e6-8b56-19256fcc52c3.png' },
      ]
    });

  }

}
