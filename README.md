# TP-AlgoPoly
Trabajo Práctico de Algoritmos y Programación III (FIUBA) - Modelo de Monopoly en Java

[![Build Status](https://travis-ci.com/FdelMazo/TP-AlgoPoly.svg?token=kj1PzEAEuR5mVTx6hGWT&branch=master)](https://travis-ci.com/FdelMazo/TP-AlgoPoly)

Link del enunciado: https://docs.google.com/document/d/1RyvpADWb5YdPkJh7CrAvl50YPDFybpk-A0Vhe_ewsRg/edit

Link de informe en OverLeaf: https://www.overleaf.com/12145961vynncnsxsbsh#/46137547/

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

1ra Entrega (13 de Noviembre):
- [X] Un jugador cae en Quini 6 por primera vez. Verificar que su capital se incrementa en $50000.
- [X] Un jugador cae en Quini 6 por segunda vez. Verificar que su capital se incrementa en $30000.
- [X] Un jugador cae en Quini 6 más de dos veces. Verificar que su capital no se incrementa.
- [X] Un jugador cae en un Barrio, se adueña de este. Verificamos que este jugador es el propietario.
- [X] Un jugador cae en la Cárcel, no puede ejecutar una acción. Verificar que no puede desplazarse.
- [X] Un jugador cae en la Cárcel, puede pagar la fianza si el turno es 2 o 3. Verificar que luego de esto puede moverse.
- [X] Un jugador cae en la Cárcel, no puede pagar la fianza por falta de fondos siendo el turno es 2 o 3. Verificar que luego de esto no se puede moverse.
- [X] Un jugador cae en Avance dinámico habiendo sumado 2,3,4,5 o 6. Verificar que su posición es equivalente a avanzar dos casilleros menos que la suma obtenida.
- [X] Un jugador cae en Avance dinámico habiendo sumado 7,8,9 o 10. Verificar que su posición es equivalente a avanzar una #cantidad de efectivo del jugador % número sacado.
- [X] Un jugador cae en Avance dinámico habiendo sumado 11 o 12. Verificar que su posición es equivalente a avanzar el número sacado menos la sumatoria de propiedades del jugador.
- [X] Todas las pruebas pertinentes que permitan verificar el comportamiento de retroceso dinámico.
- [X] Un jugador cae en Policía. Verificar que no pueda desempeñar ninguna acción y que su ubicación sea ahora la Cárcel.  

2da Entrega (22 de Noviembre):
- [X] Un jugador cae en un barrio sin propietario y compra el barrio. Verificar que su dinero disponible se redujo por el precio del barrio. Replicar esto para cualquiera de los barrios.
- [X] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y construye una casa. Verificar que su dinero disponible se decrementó en $5000.
- [X] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 1 casa en el Sur y una en el Norte. Verificar que al caer un contrincante en esta área (sur o nortre) el dinero de este se reduce en un monto de $3000.
- [X] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 2 casa en el Sur y una en el Norte. Verificar que al caer un contrincante en esta área (sur o nortre) el dinero de este se reduce en un monto de $3500.
- [X] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte , no tiene cubierta la máxima capacidad de casas y construye una hotel. Verificar que su dinero disponible NO se decrementó.
- [x] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 2 casa en el Sur, dos casas en el Norte y construye una hotel. Verificar que su dinero disponible se decrementó en $8000.
- [x] Un jugador cuenta con Buenos Aires Sur y Buenos Aires Norte y tiene 2 casa en el Sur, dos casas en el Norte y construye una hotel. Verificar que al caer un contrincante en esta área el dinero de este se reduce en un monto de $5000.
- [x] Agregar los mismos casos para Córdoba, Salta .
- [x] Un jugador cuenta con Santa Fé y construye una casa. Verificar que su dinero disponible se decrementó en $4000.
- [x] Un jugador cae en un barrio con construcciones. Verificar que su dinero disponible reduzca en función del alquiler según la propiedad construida. Implementar esto para todos los barrios.
- [X] Un jugador cae en TRENES adquirida previamente por otro jugador que no se adueño de SUBTES . Verificar que su dinero se reduzca por 450 veces lo que dice los dados arrojados previamente.
- [X] Un jugador cae en TRENES adquirida previamente por otro jugador que además es el dueño de SUBTES . Verificar que su dinero se reduzca por 800 veces lo que dice los dados arrojados previamente.
- [X] Un jugador intercambia una propiedad suya por otra propiedad de otro jugador. Verificar que un tercer jugador cae en el área y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad.
- [X] Un jugador intercambia una propiedad suya por otra propiedad de otro jugador. Verificar que un tercer jugador cae en el área y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad por un monto igual al área sin construcción.
- [X] Un jugador cae en Impuesto al Lujo . Verificar que su dinero se reduzca un %10 de su efectivo.
- [X] Un jugador cae en EDESUR adquirida previamente por otro jugador que no se adueño de AYSA . Verificar que su dinero se reduzca por 500 veces lo que dice los dados arrojados previamente.
- [X] Un jugador cae en EDESUR adquirida previamente por otro jugador que además es el dueño de AYSA . Verificar que su dinero se reduzca por 1000 veces lo que dice los dados arrojados previamente.

3ra entrega (30 de Noviembre):
- [X] **Trabajo Práctico completo funcionando, con interfaz gráfica final, sonidos e informe completo.**
- [X] Un jugador arroja los dados y ambos tienen el mismo valor. Verificar que puede volver a jugar. 
- [X] Un jugador arroja los dados y ambos tienen el mismo valor en dos oportunidades. Verificar que puede volver a jugar.
- [X] Un jugador no cuenta con efectivo y cae en un área que genera gasto. Verificar que un tercer jugador cae en el área que entregó el primer jugador y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad por un monto igual al área sin construcción.
- [X] Un jugador arroja los dados. Verificar que este paso de su posición actual a la posición indicada por los dados.
- [X] No se puede construir hoteles en terrenos simples (no dobles)
- [X] Fin del juego en todas sus variantes.

