# language: fr
Fonctionnalité: fonctionnalités d'une calculatrice

Scénario: Addition de deux nombres
    Etant donné une calculatrice
    Quand j'additionne 1 et 9
    Alors cela doit retourner 10

Plan du scénario: Addition de deux nombres
  Etant donné une calculatrice
  Quand j'additionne <n1> et <n2>
  Alors cela doit retourner <expected>

  Exemples:
  | n1 | n2 | expected |
  | 1  | 2  | 3        |
  | 2  | 2  | 4        |
  | 5  | 6  | 11       |