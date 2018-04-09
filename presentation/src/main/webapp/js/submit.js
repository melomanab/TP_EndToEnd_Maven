window.onload = function(){                             //CIBLE.EVENNEMENT
var monLien = document.getElementById('submit');
console.log(monLien);
monLien.onclick = nextPage;                //BRANCHEMENT

}

function nextPage(){                        //GESTIONNAIRE D'EVENNEMENT
console.log("nextPage");
  location.href= 'bravo.html';
}