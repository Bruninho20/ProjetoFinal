
let musica = document.getElementById('audio');


let indexMusica=0;


let duracaoMusica=document.querySelector('.fim')
let imagem=document.querySelector('.imagem2')
let nomeMusica=document.querySelector('.descricao h2')
let nomeArt = document.querySelector('.descricao i')




duracaoMusica.textContent=segundosParaMinutos (Math.floor (musica.duration));


document.querySelector('.play').addEventListener('click' , tocarMusica);
document.querySelector('.pause').addEventListener('click' , pausarMusica);
musica.addEventListener('timeupdate',atualizarBarra)


document.querySelector('.esquerda-anterior').addEventListener('click', () =>{
    indexMusica--;
    if(indexMusica<0){
        indexMusica=0    
    }

});

document.querySelector('.direita-proximo').addEventListener('click', () =>{
    indexMusica++;
    if(indexMusica>5){
        indexMusica=0
    }

});

  

function tocarMusica(){
	musica.play();
    document.querySelector('.pause').style.display='block';
    document.querySelector('.play').style.display='none';
}


function pausarMusica(){
    musica.pause();
    document.querySelector('.pause').style.display='none';
    document.querySelector('.play').style.display='block';
}

//função para a barra de time acompanhar e o tempo mudar
function atualizarBarra(){
    let barra=document.querySelector('progress')
    barra.style.width= Math.floor((musica.currentTime/musica.duration) * 100) + '%';
    let tempoDecorrido = document.querySelector('.inicio');
    tempoDecorrido.textContent = segundosParaMinutos(Math.floor(musica.currentTime))
}

//calculo para os minutos e segundos
function segundosParaMinutos(segundos){
    let campoMinutos = Math.floor(segundos/60);
    let campoSegundos = segundos % 60;
    //Condição para nao exibir somente um numero (segundos)
    if(campoSegundos<10){
        campoSegundos= '0' +campoSegundos
    }
    return campoMinutos +':'+ campoSegundos;
}
