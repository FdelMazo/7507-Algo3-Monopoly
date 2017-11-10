# TP-AlgoPoly
Trabajo Práctico de Algoritmos y Programación III (FIUBA) - Modelo de Monopoly en Java

[![Build Status](https://travis-ci.com/FdelMazo/TP-AlgoPoly.svg?token=kj1PzEAEuR5mVTx6hGWT&branch=master)](https://travis-ci.com/FdelMazo/TP-AlgoPoly)

### Pasos para trabajar:

Solo la primera vez:
1. `git clone https://github.com/FdelMazo/TP-AlgoPoly.git`
1. `cd TP-AlgoPoly`

Siempre:
1. `git pull`
1. Cambios en codigo, informe o diagramas
    1. Informe: Modificar informe.md
    1. Codigo: Modificar src/ y test/ con IntelliJ
    1. Diagramas: Modificar diagramas.asta con Astah 
1. `git status`
1. `git add ARCHIVOS_MODIFICADOS`
1. `git commit -m "Agrego.."`
1. `git push origin master` 
1. Confirmar que el build paso las pruebas de [Travis](https://travis-ci.com/FdelMazo/TP-AlgoPoly/) (se recibe un mail de no hacerlo)

1ra Entrega (16 de Noviembre):
[] Un jugador cae en Quini 6 por primera vez. Verificar que su capital se incrementa en $50000.
[] Un jugador cae en Quini 6 por segunda vez. Verificar que su capital se incrementa en $30000.
[] Un jugador cae en Quini 6 más de dos veces. Verificar que su capital no se incrementa.
[] Un jugador cae en un Barrio, se adueña de este. Verificamos que este jugador es el propietario.
[] Un jugador cae en la Cárcel, no puede ejecutar una acción. Verificar que no puede desplazarse.
[] Un jugador cae en la Cárcel, puede pagar la fianza si el turno es 2 o 3. Verificar que luego de esto puede moverse.
[] Un jugador cae en la Cárcel, no puede pagar la fianza por falta de fondos siendo el turno es 2 o 3. Verificar que luego de esto no se puede moverse.
[] Un jugador cae en Avance dinámico habiendo sumado 2,3,4,5 o 6. Verificar que su posición es equivalente a avanzar dos casilleros menos que la suma obtenida.
[] Un jugador cae en Avance dinámico habiendo sumado 7,8,9 o 10. Verificar que su posición es equivalente a avanzar una #cantidad de efectivo del jugador % número sacado.
[] Un jugador cae en Avance dinámico habiendo sumado 11 o 12. Verificar que su posición es equivalente a avanzar el número sacado menos la sumatoria de propiedades del jugador.
[] Todas las pruebas pertinentes que permitan verificar el comportamiento de retroceso dinámico.
[] Un jugador cae en Policía. Verificar que no pueda desempeñar ninguna acción y que su ubicación sea ahora la Cárcel.
