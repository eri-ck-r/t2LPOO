/**
 *
 * @author Erick Rodrigues de Lemos Riberio
 * @author Luiz Alexandre Espíndola Cunha
 */

package t2;

// acho perigoso usar essa enumeração pq:
// eu posso atribuir, por exemplo, perpective ou parallel para uma luz ou vice-versa
// que no caso não faz sentido nenhum e quebra tudo o código

// como no caso desse exercício tanto a camera quanto a luz só podem ter 2 tipos
// acho melhor a gente só colocar um sla int type e colocar 1 ou 2
// pq de qualquer forma a gente vai ter que fazer um switch case com enum tb, entao da no mesmo e nao da pau
public enum GameConst
{
  PUNCTUAL,
  DIRECTIONAL,
  PERSPECTIVE,
  PARALLEL;
  
}  // GameConst
