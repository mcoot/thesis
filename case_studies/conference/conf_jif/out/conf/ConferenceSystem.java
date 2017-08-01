package conf;

import jif.util.HashMap;

/**
 * A system to handle the submission, approval and session allocation of papers to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
    private boolean allocationsVisible;
    private int numSubmissions;
    private Paper[] submissions;
    private HashMap allocations;
    
    public ConferenceSystem conf$ConferenceSystem$() { this.jif$init();
                                                       { this.organiser = new Organiser(
                                                                            ).conf$Organiser$(
                                                                                "TheOrganiser");
                                                         this.submissions = (new Paper[5]);
                                                         this.numSubmissions = 0;
                                                         this.allocations = new HashMap(
                                                                              jif.lang.LabelUtil.
                                                                                singleton(
                                                                                  ).
                                                                                toLabel(
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    readerPolicy(
                                                                                      this.
                                                                                        jif$conf_ConferenceSystem_O,
                                                                                      jif.lang.PrincipalUtil.
                                                                                        topPrincipal(
                                                                                          )),
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    topInteg(
                                                                                      )),
                                                                              jif.lang.LabelUtil.
                                                                                singleton(
                                                                                  ).
                                                                                toLabel(
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    readerPolicy(
                                                                                      this.
                                                                                        jif$conf_ConferenceSystem_O,
                                                                                      jif.lang.PrincipalUtil.
                                                                                        topPrincipal(
                                                                                          )),
                                                                                  jif.lang.LabelUtil.
                                                                                    singleton(
                                                                                      ).
                                                                                    topInteg(
                                                                                      ))).
                                                                              jif$util$HashMap$(
                                                                                );
                                                       }
                                                       return this; }
    
    /**
     * Upgrade a paper's policy such that its authors may only be viewed under the double-blind conditions
     */
    private Paper upgradePaper(final Paper paper) { try { Author[] paperAuthors =
                                                            paper.getAuthors();
                                                          Author[] upgradedAuthors =
                                                            new Author[paperAuthors.
                                                                         length];
                                                          try { for (int i = 0; i <
                                                                                  paperAuthors.
                                                                                    length;
                                                                     ++i) { Author u =
                                                                              paperAuthors[i];
                                                                            upgradedAuthors[i] =
                                                                              u;
                                                                } }
                                                          catch (final ArrayIndexOutOfBoundsException ex) {
                                                              return null; }
                                                          Paper upgraded = new Paper(
                                                            jif.lang.LabelUtil.singleton(
                                                                                 ).
                                                              toLabel(jif.lang.LabelUtil.
                                                                        singleton(
                                                                          ).readerPolicy(
                                                                              this.
                                                                                jif$conf_ConferenceSystem_O,
                                                                              jif.lang.PrincipalUtil.
                                                                                topPrincipal(
                                                                                  )),
                                                                      jif.lang.LabelUtil.
                                                                        singleton(
                                                                          ).topInteg(
                                                                              ))).
                                                            conf$Paper$(paper.getTitle(
                                                                                ),
                                                                        paper.getAbstract(
                                                                                ),
                                                                        upgradedAuthors);
                                                          return upgraded; }
                                                    catch (final NullPointerException ex) {
                                                        return null; } }
    
    public void handleSubmission(final Paper paper) { try { if (!this.allocationsVisible) {
                                                                this.submissions[this.
                                                                                   numSubmissions] =
                                                                  this.upgradePaper(
                                                                         paper);
                                                                this.numSubmissions++;
                                                                if (this.numSubmissions >=
                                                                      this.submissions.
                                                                        length) {
                                                                    Paper[] newSubmissions =
                                                                      new Paper[this.
                                                                                  numSubmissions *
                                                                                  2];
                                                                    for (int i =
                                                                           0; i <
                                                                                this.
                                                                                  submissions.
                                                                                  length;
                                                                         ++i) { newSubmissions[i] =
                                                                                  this.
                                                                                    submissions[i];
                                                                    }
                                                                    this.submissions =
                                                                      newSubmissions;
                                                                } } }
                                                      catch (final ArrayIndexOutOfBoundsException ex) {
                                                           }
                                                      catch (final NegativeArraySizeException ex) {
                                                           }
                                                      catch (final NullPointerException ex) {
                                                           } }
    
    public Paper[] getSubmissions() { try { return (Paper[]) this.submissions.clone(
                                                                                );
                                      }
                                      catch (final NullPointerException ex) { return new Paper[2];
                                      } }
    
    public int getSessionNumber(final Paper paper) { Paper upgradedPaper = this.
                                                       upgradePaper(paper);
                                                     if (this.allocationsVisible) {
                                                         return this.declassifySessionNumber(
                                                                       upgradedPaper);
                                                     } else { return -1; } }
    
    private int declassifySessionNumber(final Paper paper) { jif.lang.JifObject sNoObj;
                                                             try { sNoObj = this.
                                                                              allocations.
                                                                              get(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  toLabel(
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      readerPolicy(
                                                                                        this.
                                                                                          jif$conf_ConferenceSystem_O,
                                                                                        jif.lang.PrincipalUtil.
                                                                                          topPrincipal(
                                                                                            )),
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      topInteg(
                                                                                        )),
                                                                                paper);
                                                             }
                                                             catch (final NullPointerException e) {
                                                                 return -1; }
                                                             jif.lang.JifObject sNoObjDeclass =
                                                               sNoObj;
                                                             jif.lang.JifInteger sNo;
                                                             try { sNo = jif.lang.JifInteger.
                                                                           jif$cast$jif_lang_JifInteger(
                                                                             jif.lang.LabelUtil.
                                                                               singleton(
                                                                                 ).
                                                                               toLabel(
                                                                                 jif.lang.LabelUtil.
                                                                                   singleton(
                                                                                     ).
                                                                                   readerPolicy(
                                                                                     this.
                                                                                       jif$conf_ConferenceSystem_O,
                                                                                     jif.lang.PrincipalUtil.
                                                                                       topPrincipal(
                                                                                         )),
                                                                                 jif.lang.LabelUtil.
                                                                                   singleton(
                                                                                     ).
                                                                                   topInteg(
                                                                                     )),
                                                                             sNoObjDeclass);
                                                             }
                                                             catch (final ClassCastException ex) {
                                                                 return -1; }
                                                             int r;
                                                             try { r = sNo.intValue(
                                                                             ); }
                                                             catch (final NullPointerException ex) {
                                                                 return -1; }
                                                             int result = r;
                                                             return result; }
    
    public void performAllocations() { try { for (int i = 0; i < this.numSubmissions;
                                                  ++i) { this.allocations.put(this.
                                                                                submissions[i],
                                                                              new jif.lang.JifInteger(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  toLabel(
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      readerPolicy(
                                                                                        this.
                                                                                          jif$conf_ConferenceSystem_O,
                                                                                        jif.lang.PrincipalUtil.
                                                                                          topPrincipal(
                                                                                            )),
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      topInteg(
                                                                                        ))).
                                                                                jif$lang$JifInteger$(
                                                                                  i));
                                             } }
                                       catch (final ArrayIndexOutOfBoundsException ex) {
                                            }
                                       catch (final NullPointerException ex) {  }
    }
    
    public void setAllocationsVisible() { this.allocationsVisible = true; }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501547428590L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAMVcC3xUxdWf3YWEBAghvMIrLBBQRBNBRDFQHgkINEAkhNaI" +
                                                    "hpvdm+TCZu9m790QQOrjQ/FRaUXw8RPwSavWatuvaFtR1EpF2yo+i/bzUfoQ" +
                                                    "a2l9oGirtXPOzH3Nnb1ZbPuZ3y8zd+fOmcc5/znzn5l7771HSE8jTUau0loq" +
                                                    "zLUp1ahYqLXUKWlDjdfpibXLaFJT7JPbfhW/8dzUG2GS10h6aUZD0lBa1FpS" +
                                                    "oGTMNj2tmWtNUly7SulUKjOmlqis1Qyzqpb0julJw0wrWtI0Osg3SKiWFGs0" +
                                                    "RUmammKq8Xlpvd0ko2tTtKLWhG5Wql1mZUpJK+2V2JTKuuqEYhi0pDxMtQrp" +
                                                    "lUrrnVpcTZtkVC1tOM+dUJrVRGUdv1cLv6q60iRqFc/7xzqHJbPebZtYufWG" +
                                                    "C4p/FCH9Gkk/LVlvKqYWq9aTJm1PI+nTrrY3q2ljdjyuxhtJ/6SqxuvVtKYk" +
                                                    "tHU0o55sJCWG1ppUzExaNZaqhp7ohIwlRiZFmwh1Wom1pA9TSSZm6mmrO3kt" +
                                                    "mpqIW796tiSUVsMkgx21sO7Ng3Sqi0KqTjXdosRUS6THai0ZB10IEnYfy79K" +
                                                    "M1DR/HaV2suuqkdSoQmkhFkuoSRbK+vNtJZspVl76hkTFDwsa6FVYAgltlpp" +
                                                    "VZtMUirmq2O3aK4CVASImGSQmA1LolYaJljJZZ8ji6dvXp+cnwxjm+NqLAHt" +
                                                    "70WFygShpWqLmlaTMZUJ9jmp9npl8MNXhAmhmQcJmVmeBy98b9bJZY/uZ3mG" +
                                                    "S/IsaV6lxsym2J3NRc+NqJ4wLcIgqBsaGN/TcwR/Hb9T1ZWiA2uwXSLcrLBu" +
                                                    "Prr0F+defI/6TpgULiB5MT2Raac46h/T21NaQk2frSbVNAyRBaRATcar8f4C" +
                                                    "kk+va7WkylKXtLQYqrmA9EhgUp6Ov6mKWmgRoKJ8eq0lW3TrOqWYbXjdlSKE" +
                                                    "5NN/MpL+96L/u3l8i0lW1py1osFQ0/NoKcaKGj2WaVfpAF7RkNRWmG2qoRkr" +
                                                    "YoqhNhlmJq7RHBTRXOt42UQH5AojHcMfK6rtm/VrDVNtr6B3U/8PdXRBP4vX" +
                                                    "hELUBCNEB5CgY2e+nqBOoim2NTNn7nv3Nf0ybA8IriGKVSi9QiydhEJY6kAY" +
                                                    "NMyo1CSr6eCmTq/PhPrzF668YkyEoim1pgdVKGQd43Gu1Y4HWIDOMEZh+MLM" +
                                                    "1MrNpw+fHiY9G6mTNGrUFiWTMOuq5+iZJHUmA+2kpSr1M0n0blIPm5+KoYxJ" +
                                                    "hvh8I/OJVCztFAJiwyn0y8UBKGtmv02HP7r/+g26MxRNUu7zEH5JGOFjRDOk" +
                                                    "9Zgapz7TKf6kqLK76eEN5WHSg7oN2jeT9gy8UJlYh2ekV1leE/rSk3avRU+3" +
                                                    "Kwm4ZWml0GxL62ucFMRHEV73p1bqbY0F+h+5gceXwd0BKQgHMjyB2YVeoFee" +
                                                    "UZ/acfCZt08Lk7DjwPu5JsR61axyOQ0orB+6h/4OipalVZXme+3Guuu2Hdl0" +
                                                    "HkKI5hgrq7AcwmrqLOi0SNV82f6OV954/c4Xww7sTDpnZpoTWqzL7iSkk0Le" +
                                                    "uY08/oark7S28U57qNNJUMdHm2uUNyTb9bjWoinNCRVw/mm/cZN2/2VzMcNB" +
                                                    "gqYwrabJyd0X4KQPnUMu/uUFx8qwmFAMJj1HZ0425kkHOCXPTqeVtdCOrkue" +
                                                    "H3nTk8oO6pOpHzS0dSq6NoI6IGi0U7H/EzGsFO5NhiBKh7N4k1Y33Bm0OHgo" +
                                                    "b9AYqWiKDX5/TGVqXs2baO9CcBOUK2kxyoJG+MZctX0XBh7M3a1W5pG+zAuc" +
                                                    "2zBkhoht4PX3OD8afz865jwcJ73jqhFLaykLWNTTFxpaeypB1a3GcXhTjmHq" +
                                                    "C6n6bMKUVpJGgk4wzCUsw5tzu1JpmK47lTTaCbUytgtAajejDnhYU+yMqzel" +
                                                    "9bFXTQ1zRRZBMLqLssA481LRVCyasNzLWQBjLMOq1lGmU3VTbMegG/aUfG/L" +
                                                    "bDYXj/JK+HJPP7X68qYpP/w1gh4AUiZqa6mqUB/P1NkUe3/nq+rS0z/5Kxuk" +
                                                    "+pqkyB9TlPrEtJQCHJJfAfVMYynQj1m0VaU+WPDip15z6/1HXq+bhVh2GQAI" +
                                                    "go+jcgu7VAdhtXeusNtTsUxP2U1qil0w+MDEEXvOvdKtJkHAlXvz3dvz/3by" +
                                                    "J7dit20YjBVgYAsEQgHCaay96Cs8BnI30m2nIYNee3F/5/y/suaKOJBJzJw8" +
                                                    "8JHDpUPXc8tChTW8VojmS439NboMcYwdrah9fG/+0qddxkYLUhWswYzMnhDO" +
                                                    "dgywmBY8TqbPObpp6u0urc4Y++qqqs+e+7E1AObaWpng7aAg6e5m3kkPDd38" +
                                                    "24uXWGUsYF1d4urqOSxpSqoLPXQD/ppugGcQ2Md8xWijs8fBxG8at712UhlT" +
                                                    "tmt24fd/VnPZtut/8uAURlD6UF9XPHMWIczpQeEzU9iWRtaUlKcZws9FLGsT" +
                                                    "M1DKNo73J4tL0bHCSnOEhwzNg6WPQwBi62b8acs/OygBiDSSojbFWJCkEyas" +
                                                    "tOiCDryn/csk/V3DCt0S0ICEm9KIywOhssbKe7cPq/7KOzhiHbYB0qO6/LRx" +
                                                    "ueIiQpPvaf8wPCZvX5jkU76GLIyuapcriQzM4Y10kWZU88Ra0tdz37vgYquL" +
                                                    "KptNjRCZjqtakec4dJVeQ264LhSoDfyTiewiPJfHE93UJkTwYjWKjMFwHAQn" +
                                                    "os3CcDnBpDVrSSUhsIliXt5JPC5zlWuSAj3dqiQ1yvMNz1yGrlyNswXYrrvu" +
                                                    "va+qz927cKQWoP2oNU0+b/UCCes361pfb9eivOqzZF1jo8cWGCYTmOIWwCjD" +
                                                    "hxmEX5MOErvE4ZA4ipc0jceni8RxLe1/udRPA25dbmWE1p658+jTdQjJvrjp" +
                                                    "YRnfJENFwDvsGl2Qt1EjeGOmyhpl+KZXLNDtnQ7WfrZzxsuP7Lan16ECC3AG" +
                                                    "w9Sn7ok8u3zFDmZCF213z3yw8nFtHfA9i7JsfWJbFtixNrtjZdCxCXyp+hiP" +
                                                    "H3B3jDAsb5RjOcKxnGfgFg/80jmiP6d/Ifr/T/iHaiABYjpcq/mqPGovy03S" +
                                                    "vsTC9qHLtxy6atdZ/8kV7SKqP1jFnjXp1JMnTz3ltDPpajS0xPB7NAqdduoS" +
                                                    "O/mGh3rF1qs+r9i8NezaFRrr25hxy7jU3BeCKwEao4NqQYl5b92/4aG7Nmxi" +
                                                    "00yJd49jbjLT/v2XP/tVxY1vPiVZVhfY8LfWVCOyIAurGvP7/E0LDi/chVNC" +
                                                    "MbhVJCXUr4KrwKQFSW9Sb82wxxR27VoIroPFOE5jXjyJo/dMnwOx5jsIOrHA" +
                                                    "m5yZutM7RfqTBpmkCHcSbMRgv4nL1ah2i8DZkFPo/yDaknt4fKXEW98qRzhd" +
                                                    "9+VT/VKKpwquujcv7AoeX+Jx1SVKIqHHcDvTWK4ZmsX50t6WDeXC18taJjjb" +
                                                    "ATKBb/uc7d25O9uBkFjKS9rG42tFZ/t9zL/eKzWI594ik8KsF7kch4OQIbIq" +
                                                    "twYi5B5sxW4HDvf4EeJNuoaPPIi+TQ3YrOsJVUm6YHK3DCbjWPvCL/D4ZxKY" +
                                                    "PMxgAsEdfjyA1E95/CMPHoroGK7PNLdrhgGQkGFhEBf8uax6AQv9ZAIP+7Dw" +
                                                    "RO5YAOaBpoWSHufxIyIW9gtYQClu1/BemVQAFgbIqnwsEAv7sBUHHMPv82Nh" +
                                                    "XxAWIlrSdOHgCRkOpjCIRgpYHP6dBAcHA3EAUm/y+BUPDnobwSA4gUt9Kqtb" +
                                                    "AMFomcBHPhC8kTsIxkDieF7SP3h8TATB7wUQoNRYnvtjmVQACMbJqvx7IAje" +
                                                    "xFa841j8TT8InKQ0GeZMh7iGwN0uNsE/eVrptk3XHRtCmVYjyedrDFxtLNaT" +
                                                    "+ENylOKSf/feN955vu/I+3DjqEczJSRQa6F4BuU/YvKcHGF/+niBMNqyZ1Yg" +
                                                    "CMgZxTMezQE5Q2UCf/Uh56PckYMrgTJe0gc8/puInL8LyEGp4Tz3uzKpAOSM" +
                                                    "lFX5fiByjkErQmEHJsf8yDnmQo73FJf6b8N0naN9/cTlj20calzNSNsEGyVq" +
                                                    "l1mBSw0uKsq9cjAyubdZ/i2k9zZoetHFqAE5TRLNfoKLZTF+2dvWBJ48ldD/" +
                                                    "PPq/kscNJmn4T3LoOiWlpvlx03+nYDROocXxcBu4Am/i6ZDPEk2x/tNubm65" +
                                                    "dNaTSIr7ofKQsdYzNY73rpa4UHm9N5/3SFtqu6bY4fuv2T/6z8sH4FmlZSb3" +
                                                    "gcQiJVUlHkDAFhFN75n/6mM/H7zyuQgJzyOFCV2Jz1PwLIcUmG1p1WjTE/Gu" +
                                                    "FB9YoTWwBAsTi1tf4p0ty7lx0zxWQGV9AO6hvnytFhoStFaD4AoIdMTQlXRG" +
                                                    "mo3PHKBCZDOmvQUUYnsgQNZCZSREBJ8C+ENmB8PwCI/fEn1KKJq7T8EeD+El" +
                                                    "/YXHhwWfEioXfIrNKiD32zIpn0+psYUHy6p8xyc83/EpIdzpDJ1sO5DQaJ9P" +
                                                    "cZK6urw7F9lhOakqtvhxfdoExHae2aYZ5afieY4E0lVMtQOxkkpEUQ8bQehc" +
                                                    "PuC8JXS6HBxhGxw2LvISarLVZHsFaVaG7BRnGW0ZP0W5/qOBSy/92scN6NfC" +
                                                    "MeRZo2pJr5ZMIrHYXrFCeAYrzySzsJCo3hKlbiNqpNSYpiSi1i55dAz0e0xU" +
                                                    "S0bRD5y3fsmhy7dsOB+jQ1ft2nDe+Sl7h9neealWkknd9B1v5MW03UcqWz6z" +
                                                    "dodnMPu8y7tmd/NDvPsR+iIIpuDejvQQbm57ysRjs3U/GfLj6d/d+Tru7fis" +
                                                    "IM4ji3Dqd7Z7zritpnzE4x2b/3Nn1fBzuPxYepRAZsTG3L3o3qfOHh/bEiYR" +
                                                    "ew/V9yCMV6jKu3NayGpd5tk/LWNqBoXOdKjzeMQa/pYeKIYWBtyrheBs6qBi" +
                                                    "CT2pdm/MVCoVChHiK4v5MXYiEDqnW/eEm/ShZcxxZNukZ+6BZT2X+YFsW/8Q" +
                                                    "NnTBRkNpNpBDlpdQdWwQ4/wfmgNBNQnBXb6ceUO2nDmVcaxIJ4+Xut0ZdwtN" +
                                                    "gcsZkDqHxwtd0nTycG1zCKQ03/LDMKHt4vGNJjmzsk1vVytXqfHKNXp6dSU4" +
                                                    "tDgdQ3iR0JpPocQAr3Fe5XMo5x1fWJYbGbq6khm6rVtDs8wQrnY8+Uq/c1/p" +
                                                    "45lcLGsef1IoHwIVxTIWAyoGr+FmEpizGMNBvLER5AvowgW+gHtx47jeH+Dx" +
                                                    "/SDbggpotfjCuix8wX7iwd7fFQ4tjm+LNwV7rstthhG6BDs7EoJOCEYJfAL2" +
                                                    "23FpCahr43GzG7vY+sty5xO4YBjNS2rlccxdIhR4pcAn7GUG5I7LpAL4RFRW" +
                                                    "ZYtP2M0nLsdWXOsA5XI/drxJjs1hRwgVB7b+Po+/I7H59dk5YgieYAldBMHF" +
                                                    "2JRLqN2+Chcbs9oKtwSH8e6t5HGjz1Y3524r7MlQXlITj88TbXWLYCuUGsxz" +
                                                    "r5BJBdiqVFblBYG22o6t+K5jmO1+W213cT/4PQkC9vgTs0Vbl2tCtFuDf3nc" +
                                                    "hDst9+lqDeYsdZ6vGZntgU/c9b/z0q0740t2TbLYz7UmXX3oqVMSaien/ayo" +
                                                    "fGyjoxScQU4meErUM4/FPf4k2IEUB04fIPJHHr8u9sCZ292k1ZlGToNS5vEG" +
                                                    "RHnc12MVzw4PY6Wz062clN7Vd98vj5TO2487NOGYBk8J+Z6vi6vZuEwmRadk" +
                                                    "N6cKd2pwtYrxWLuZs2TNHOZupkkugHrb9XSqTeMP8wDxZc/WRZV0Ky6ioykg" +
                                                    "AXCD7RBFM6nWtBJXkRtET2yGpqjxqNKsd6rR5rVRmyZMYNMDo7UheL4jtJsZ" +
                                                    "By4fCFI2ZHiIoXMPBHsR1o8iOh/7csvzPzbQkFyd1Nck2VZKfe97M//z8CkH" +
                                                    "LVjzMzes75kA7vg8BD82SR+3diHtgIwgSp6O4a3gIBtY+ZcdSz4+9AOrGWew" +
                                                    "3qU8JnlJSKSzKdraoSZ7mZv8be5ucjYkzuVwG8Xj4aKbfF1wkyg1h+ceIZPy" +
                                                    "uUln261GVmWZT9hNh5j9/+T4xL1+N+kkiY+01FKCmXAWKMu++eRvpt50eAsu" +
                                                    "jIOfTxEkE3cmnqw9uvYZy0rOOTg6mVrel/EyJ8N58hH5vIkc3F45u8zKh4Jt" +
                                                    "VcbzemPCBx3WnorA6Vx7QB32fo4z2cK5KpnJGzmUxwPcjcWmHsfmLTy5Qb7C" +
                                                    "Syrl8UARReLmLUpV8dyDZFIBKJohq3JIIIpw8zbsbN6G/Ju3TpJ7sj3q80RQ" +
                                                    "UC/0RlL1wJ3HIXgPDYeGR4vhnaey+5Vwb/QrELwgzGP2Hj3Mgp/IJlLBzENl" +
                                                    "Ah+IZg4X5W5me48eSvqYx0cFM4dLBDPbe/SQ+0OZVICZR8qq9B8Nucwc7oet" +
                                                    "GGbblCaIZnaSQNOFRPK8sVeXQGDIZI6yPjzO8+nyOPYm4ZECMomXxElOz3xR" +
                                                    "l+LeJEpV8Ny9ZFIBujxVVmVhoC5xbzLs7E2G/XuTThKEDZb3kgH/iQDgnyYC" +
                                                    "HxL74q2ibEZClfNa87DWE2TV/jSg2jP/rWoFrosvLUQJTnG9/s7jPwo2dXNd" +
                                                    "h63brwKAyB94fNxcF85y0a1S6YKBPA6JFg7tsQWmyASK3AImaf5CrLNNScYT" +
                                                    "qvPEwvExz/B0m9mFZ3TDFMNzHKYYrkHrzMXROO9LLQ+yHkDp+gD8NUBQZZJi" +
                                                    "UV8d2bhkB2eCtAl+euhO9NFD2hnsx/m5e6nTIXEax8UAHvcTvdRKwUuh1FSe" +
                                                    "u1gmFeClzpRVWRLopZiR2hyXVOP3Up6k0DveITOLVzNMNmQYcwu3fwHmRqGE" +
                                                    "Ckdf5AMVBAYCKxuJCJ8NQYdVRri9w3Jq4cUBoOpEUEHgbJe5DuR6dOpavPs5" +
                                                    "DxwZPlgBGiGWV3NrBvWyPnc04fMm43hJn/P4HyKaLhLQhFJjeO5PZVIBaCqX" +
                                                    "VfnPQDRdiK3Y5EDnQj+aLsw25/nstCDATpsdO0GwJstcs75DnOJ8tcwKqGXL" +
                                                    "8dQim9Eg5/mUgD7A4y2CxbqZ0UDkWh5f7RINaPJNAfduhmCrSYpaVTP7A3H2" +
                                                    "VAy1flfWcAHtw2QCt/nQfkvuaLefRIeSvsPj20W03yGg3X5UHHLfIZMKQHuZ" +
                                                    "rMpdgWi/FVvxPQfat/rR7k1616vkYZausioZx8UPXScovSmrKLXeS1PgYago" +
                                                    "PMRiv58W/t9utdxhrYLDD9rtpAli04WkRY7YntzE4Acc/MFLxlkcJpS2DccB" +
                                                    "DrLHc2k7Ewjvw4QaloDX1kGgP2mRI/a0Y5ptfmtt8/gm2YAGf6gS0vdKHuvH" +
                                                    "N6BBJMnjtuwDWk5RcSU1k0vfweNvi5hxUdRpMoEdboEvSlHBgajoPRZn4IMS" +
                                                    "x0lRDzgU8LmgrkOGl12U8iDa8BV0J69+qeV12BT1rQCH+zYEz1KKKuqro1uK" +
                                                    "ekBGUQ8EUdSDzM2+l7ubtfeeABe383ingOjwUcHN2ntPkPsWmVSAm50hq/I2" +
                                                    "n7DbzTIjfeqM0oP+getJclFUHDJzeTV3y4YMo6gRBpDjpKgvY8two+oDH6ig" +
                                                    "1HwEltQUcAdW25GeVhkRBBUjJYeygypSiKCC4M+ymXsg72WXzEMJM3eRTCDt" +
                                                    "FkDl9M0dUvhw/ABe0hoeGwKkIv0FSKFUMc9tyqQCIFUiq7IzCFKRImzFUBs/" +
                                                    "NEGElJME4Uvdc358mHoir/5b1jTh0+Wo3HUJCwhyEi9pM4+vEnU5VtAlSp3A" +
                                                    "c18tkwrQ5QRZldcE6jKKrZjoKC7q12XUM6+6Ob8I/NcCgD9ZBD4k9sFbfbMZ" +
                                                    "CVXOa3UtAsRqXwyo9ox/q1qBRNjvRFEWUPQzHt8k2LSbM10QuZHH7nd/ciIR" +
                                                    "uG11Npd+kce+Fz9cJGK2TOAZt4BJtC9EIuABN4VOii1r/w0uEamy5+rI9G7m" +
                                                    "/shsZ+6PVKORanBQzv1Sy+uwuERkaQAMl0FwlkmGZFFbR3eUgrbETynciT5K" +
                                                    "QfuE3VmRu8+Ck008iweUvMDjZ0Wf1ST4LJSq5rkPyKQCfNZcWZXPB/osZqtW" +
                                                    "x0FV+31WdRZKgQNoEa/mVdkA4pQi8QUoBUUUKhyqLPRhCwLMNTcbpYjMgyBl" +
                                                    "lRHBZ8fxKdDIogBsZRBbEDQI7sJ+Ow56ebvMXwnTYD+ZwHa3ALauK3dI2W/H" +
                                                    "QUm38dizioECLxQgZb8dB7l3yqQCIDVAVuWtgZBai63Y6OBnrR9Sa72Uwhmr" +
                                                    "zhMXrqdp4N2Aavsx46ZY7YcvDe48Uf8F+yiL/eIxFiJ+AwqevyJtvOEf8vht" +
                                                    "Xwfkrs1RYgsU08rFj/L4A78Ss8GRbESt");
    public static final String jlc$ClassType$jif$1 = ("bBZBgmdxp/HyHrVmQx9IrssdJHCwh6eMUNJeHj8kguQGoX8oVclz75FJBYBk" +
                                                      "kqxK//uXbpBsxVbc4iBiqx8k3iRHZ0ugugZezSEe/59PZ3fmrrM6SFzGS/od" +
                                                      "j18TdXaXoDOUOofnfl0mFaCzelmVbwbqbBe24geOgnb5dWYnuailzwHOD3CA" +
                                                      "D4oOEC7X4K2ubIMVbgKvjnwzy2CCe9/CMvZgeB3ax81DfW2cGdDGvf/dNj7h" +
                                                      "aiNjL7bVcF0Jxwh0WVOyg8eXC0DpZucLRC7j8UUu0YAOPx1w71cQ7DNJCdUk" +
                                                      "8MzZzrPwHVl26oXxhG/OlvMW3WJ1zjeenu12PEEuRt9ecBB5wA/SA35sM7GD" +
                                                      "uYlBmHVPcjudr6bxeNTxWQZEynhcmptlgrYn/gDBayYZZKjmbN+HGHI0Di6m" +
                                                      "T+CNqrL65zPOWzkZ5zC2y3lnmSb4tHzYbxwm9m5uYmgc+Gac+IlNeKau1PfV" +
                                                      "Xval2dh9O/v1GrKz4TfsFWbra7AF/L0t9xeRXNd5qbTaoqFhC9i0j++6RI6Z" +
                                                      "pAe8twnXH9uf6yjG16fg80wV7PNMXcxLlEonfPv4GR6QeYbHv3brvdsJPzs0" +
                                                      "eoS8n06C17Ey7LPITbF3J0+qeWT/+Cf5l9WyvhTqSNy/c+Hi9e9NZR9b6knX" +
                                                      "ROvWQaW9akk+W3lyZuT+BoxYmlVW3vwJ/yj6QcE4zzcAS1yDp9SN01KHyG90" +
                                                      "Pj/k/o6e+7vNTbHVZMPVT2wquQTfdC/QjGXpDIVGHL4vZD0oDmVdivWdwd6G" +
                                                      "6lFACz5B/MCcq1j3+3WhVTctqc3//Ov2+3VS+7C3lf4F1B/sIiVbAAA=");
    
    public ConferenceSystem(final jif.lang.Principal jif$O) { super();
                                                              this.jif$conf_ConferenceSystem_O =
                                                                jif$O; }
    
    public void jif$invokeDefConstructor() { this.conf$ConferenceSystem$(); }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$O, final Object o) {
        if (o instanceof ConferenceSystem) { ConferenceSystem c = (ConferenceSystem)
                                                                    o;
                                             return jif.lang.PrincipalUtil.equivalentTo(
                                                                             c.jif$conf_ConferenceSystem_O,
                                                                             jif$O);
        }
        return false; }
    
    public static ConferenceSystem jif$cast$conf_ConferenceSystem(final jif.lang.Principal jif$O,
                                                                  final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$O, o)) return (ConferenceSystem) o;
        throw new ClassCastException(); }
    
    private final jif.lang.Principal jif$conf_ConferenceSystem_O;
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501547428590L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM28CcwsW1oY1u++N2/2FQ+MgRmuhweecQ+vtu6uaiZE1NLV" +
                                                   "1VVd1dW1dhUzftTate/VteAh2DKLQwQxGWysGCJFJIrJGBQrOIktSyTyhrAt" +
                                                   "hVhOUGRDIpw4IVh2dllOnOr+/7u8e++75knBckt1zvnP+u3n+66+c7/227P3" +
                                                   "1NXsYZEnwznJmzebofDqN0Wrqj2XTKy6VqaOt5yfnANf/ZN/8GN/7tXZR83Z" +
                                                   "R8NMbqwmdMg8a7y+MWcfSr3U9qoad13PNWcfzzzPlb0qtJJwnCbmmTn7RB2e" +
                                                   "M6tpK6+WvDpPLteJn6jbwqtuZz7q3M8+5ORZ3VSt0+RV3cw+to+siwW0TZgA" +
                                                   "+7Buvrifve6HXuLW5ez7Z6/sZ+/xE+s8Tfz6/SMsgNuOAH3tn6Z/IJzArHzL" +
                                                   "8R4teS0OM7eZfcuzKx5j/AY3TZiWvjf1miB/fNRrmTV1zD5xB1JiZWdAbqow" +
                                                   "O09T35O30ynN7BvfcdNp0vsKy4mts/dWM/vUs/PEu6Fp1vtvZLkuaWaffHba" +
                                                   "bae+mn3jMzx7ilu/LfwrP/Z9GZM9uMHsek5yhf8906LPPLNI8nyv8jLHu1v4" +
                                                   "oT+w/xPW1/+lH3kwm02TP/nM5Ls5/8kf+sff/YXP/NJfv5vzTS+Yc7Ajz2ne" +
                                                   "cn7W/sh/+c3k59evXsF4X5HX4VUU3ob5javi/cgX+2KSxa9/vON18M1Hg78k" +
                                                   "/VXjB37O+60Hsw/sZq87edKmk1R93MnTIky8autlXmU1nrubvd/LXPI2vpu9" +
                                                   "d2rvw8y76z34fu01u9lrya3r9fz290Qif9riSqLXpnaY+fmjdmE1wa3dF7PZ" +
                                                   "7L3TN/v09L1v+n7xvv53mtn3Ut/5JbX2Knrapf4SlTtt6mVN/SU1C7/UBF4d" +
                                                   "1l9yrNp7q25aN5xmTPJ9T/Vb860o9L9UV87tjy+RjwfloW689M1ptPgXcEZ/" +
                                                   "xfPD3SuvTCz45mfNQTLpDpMnrle95Xy1JTb/+Off+pUHjxXinkKTrF53f/PZ" +
                                                   "3WevvHLb9fdcleaOqRNL4knVJ23+0OflL7Pf+yOffXWSpqJ7bSLodeobz8r2" +
                                                   "E4uwm1rWtPdbzkd/+B/8n7/wJ76SP5HyZvbGc8r3/Mqr8nz2WQyr3PHcyTg9" +
                                                   "2f4PPLR+8a2/9JU3Hlwl4f0TZo01Sc2k4J959oy3KdEXHxmkK1Ue7Gcf9PMq" +
                                                   "tZLr0CMr8oEmqPLuSc+N9B+8tT/yz6bfK9P3/16/q7xdO671ZHXIe1l/+FjY" +
                                                   "m1l++O9/6Ce+83dbOL4TguEvwOB3wIviTk6u7HyGhDdr+11y8dP/zd/6n5AH" +
                                                   "V9QfGeaPPmXBZa/54lPG4LrZh25q//En0qFUnjfN+7s/Jf5bP/nbP/w9N9GY" +
                                                   "Znzriw5841peCWNNBMmrH/zr5a/9+t/72b/94Ik4NbPXi9ZOQucG+TdPG337" +
                                                   "k6MmO5FMtmqCpH5DzdLcDf3QshPvKpr/9KPfBv3i//JjH7uTr2TqueNWNfvC" +
                                                   "P3+DJ/2/l5j9wK/8wf/rM7dtXnGu99QTcjyZdmf8vu7JznhVWcMVjv4P/+qn" +
                                                   "/9Rfs356MqOT6arD0btZo1futeUK1Ccm6ZjY9Ob1RppkOcycsLCSG8JfuE34" +
                                                   "/bdyfhWk27LZbQy8Ft/U38Y+eev/QP38HUFfL9snemECX/vT30j+q791w+eJ" +
                                                   "Xlz3+Mb+eduhWU+pLPxz6f/x4LOv/5UHs/eas4/d7nkrazQraa8MN6ebuibv" +
                                                   "O/ezD79t/O237t0V88XHev/Nz+rkU8c+q5FPbNbUvs6+tt/7tBJOhPj4lUjz" +
                                                   "u8aDzX09v45+rLiWH+9fmd0aq9uSb7mVn70W33bHl2vz2+9Erpm9P6/OVhZO" +
                                                   "KvqIXR+5mcrDo+47pbqW8GMQPnQF4Tum75PT0T93X/+xF4DwXe8AQjN7b1GF" +
                                                   "l8lQ9I83vTH/g/eb/ch9/Yef2nSis5UkuXNz22otrMNJml8gFZOUpZMKX+49" +
                                                   "B+9Hvvqv/7M3f+yrD55yr771OQ/n6TV3LtaNQh+4kamfTvl9LzvltoL+H3/h" +
                                                   "K3/xP/jKD9+5H594u7Owydr0z/6d/+dvvPlTv/HLL7if3mvneeJZ2TtS+9um" +
                                                   "7xsmgvxX9/VfeAG1uTtqX4vvfp6s11X/2X39595G1o9MsMmtnYZ1faXsbSl1" +
                                                   "j/i12jazVydH9R1hW0zfp2azV99/Vz/4714Am/xS2K6rfuO+/rW3wfbB+inA" +
                                                   "nnctb6bojs//6Gu//lu/+uFP//ztVnzNnm6Vm/Y865M/73K/zZO+cf39jyH8" +
                                                   "uiuE2NX8TFL7qbt69r81M+X/z3uNn8zUvTP1u7Jv/0i1P3BTbdEq7rV9/oyx" +
                                                   "hq+F+Yhl3/ti5X1wsx/NZLnC7N6ST3bk9cTLzncuqXgtjP7xCQ/ulj0C4u4i" +
                                                   "ud0HZJJn3vVOejR254iF+ZuPQ7RpsH8O1mr2Lc/IAX9j4RNz/mf4r/3y9tud" +
                                                   "n3gwe/WxJX4upnr7oi++3f5+oPKmkDBT3maFf+8dgW4IXovf95IrLH/JWHkt" +
                                                   "0omGzpUCj7D/2BPK3N0i/TuqHDh93zSp3OW+ll6gcu1LVe666nhfs29Xuaes" +
                                                   "7BPQpjv8ZsgYqw54q3gKsjtL8cpk1N+DvLl4E7n+/YdeLDuv3svO6/UtSr/+" +
                                                   "5TySoG+IEueNR46kNknodP4b07EvoM5dZPsCECbJ+MiTaft8Cn9/9Df/zb/x" +
                                                   "49/665PNZWfvuVzv68k4P7WX0F7/feCHvvaTn/7gV3/jR2/e2SRiX/63kfEf" +
                                                   "Xnf9o9fi+6fY+QqdnLeV4+2tuuFv7pTnPgbwGXv52sTXFwHYPJwxi3qHP/rx" +
                                                   "mkMivdq7uo8Y+obAz8GF31V7gjhKhEBIFH1kzvFO2OBxIFi7oLi46VwhzXad" +
                                                   "omvweDxU0RGgJUs9dZgkdrJ10a2mvVh0I0GbgoaHfB4C9qj6+dGCk3W+Davm" +
                                                   "JB5GBhEyGzJtsTWRARvduX9IHWcJjNmYLRMURSFG3mCRolotmOTluFcLyAqM" +
                                                   "cn9SOT2hItcvQvu0t2hWQVnR9gMdwNxR3cJbGQKDlaWaFJgQFkQXcr5VeCGC" +
                                                   "m1RvBDUZULlNVC46pEkZ1tBxGMvCBqM2YTuwq/RmBx7qMyJzoU5va1BSUytN" +
                                                   "uRI7JRPmYJzDjdJwez3YLvUygVJTLVhuDmswq3BtW26MIAQLquebY1UkalVl" +
                                                   "WuEoZhNrJNQc+LmrspUmbVX3Ajn7y6pcgaFU0g6A9mPJsLbo2WZjtL6+JRcF" +
                                                   "QJPMehvHwF5LLlxp6OXaUtgUEnfzTKkqAynhJHKjoe2DhgVWctm3F63hjLhh" +
                                                   "VDBfLmuW1LdQUajjprcE0yqDAs2DXZdIoUmnXQDpeQoV+FqRZTNdpWl1QOIm" +
                                                   "Lcqdjq5XTSirWs3H5x6G6gMqTBQpQ5Arlejk5rWkyiuFsULQJCBwt8kMf0DX" +
                                                   "HA9REsBYGlxPlIhdOT+mcUDHbS5LNje/CA1r1oWWoKsgVmiqq60VrRn4OWmS" +
                                                   "otDMhlfDKi3hA2JxC1LD5V26lY8pDu3zxLDYJGJNE4vClXs5FXMn6/oonQvl" +
                                                   "HmcaFNTp4SwHhV7u08RSeFNl11FarLMiwXjhFOBpkB4dNtVSjxjWmL22WdMA" +
                                                   "JsGbTgB2taWtkr4eUphFBMmZNmUX3d7ZnUuitrYCoDjdhJa9ViBTD3G47U7y" +
                                                   "3pkUpBWrCqTnrufvgJVSnNV9SCx5BZYsy1msAkCBIcE6xrBfybYm4INEWBKu" +
                                                   "OFaF+QsyjucXC9XjIeFOzf5olFWKrzfBWS1Wh8sq5fT0LOUci3klmOiIUh1K" +
                                                   "3bBPkZvI3GYpCABf7Ofr1R5okQQLpylQMUB5TR9BQMg5x+K2Eaxbml/gNCrF" +
                                                   "gqSnW7jMpbgy8jIQgiRlS1RiCEU6HZoFrB6ZJZ5HjMP73KpqUkCrKE1oqhWB" +
                                                   "qAAmuieJEBeXU7DZqwQpbIgleTZgb56VxCEPU1hQhAzNLojgg4ONY7sq3HKa" +
                                                   "HK6P4eAGG9ZYxbgh8EMOkXK18shUKQExEKuRXq0wIx420x5QcXY1bnt0F8i2" +
                                                   "hYwFo++oA78xgzm/5yG+Eopu7jOhsd6uUkXYViod6gp/aMvlPDRZRk3xORwX" +
                                                   "cgXxYAbayU5Ml3MuN3o2uATYDjiwGjk2NM6G3ZCBA6YS3LZJLyDMiGgFzM/w" +
                                                   "iu8lQW3RccMs2e2BjiTqEK/Ns1WMqML5q7jcc+jK2whLnZHPaC7Akaesz9NO" +
                                                   "bGIEsBdrUOJtgEqOEesiqXOE69KFqacJuO33K7h1aF5iNhqKFJBd2sYkNsF8" +
                                                   "eXa8U+eCBHc8M3w0ELCheTnteaoJWI5Pmg2I7WOUijqxXbK1tIKsfjgcwbwi" +
                                                   "5pN4LQ7XOFYzT6k3n4jWtjDjJiATc7tlcK5KFHe6tCr3hxCUBQ2D/dVBWy8X" +
                                                   "gLM4dR1aK1SRmUWu6JNlRUM5jsG91xogBuRWFaMyjKlLtBQEVuVdJoVbVRiU" +
                                                   "SW0iPQ8zgZS0DkhTwDEFGIC1kXcE4lwaXWXZ7OCCpwV3FDOVb4FWpXus7FIa" +
                                                   "59kIYkxwAS/jmDmQJ1EpPa1xyUMVtx6DZEqM5YdVcSiYUQZduVwJ+W6124ag" +
                                                   "ijLAZtzW9GEpBCHBBaiwiCEDQYgUPDDn3F7jRqmHHHVaAspWK081bFuHNekQ" +
                                                   "B5WD437I2e2cN53mBJ6IAOURC9KXxXY+4q0Dj0Qc5EGzEE/IgcIsf8RWy6hz" +
                                                   "WBSJyoDeW0O81wVFofvC8oaCgCxk65wCJUqZklxlK5vnVK1gt+d40Y2kWnfL" +
                                                   "Zmwhtki5BZooikXa6tCcG9yKvIjKAkOdD3w5esnapk/KERolyST4fbmva3yB" +
                                                   "QXtJIwerFsa9fiSiPX8ooWSbqoim2Lx33gKW6m+BvU0ZpwiYrhyGFUX0tMJK" +
                                                   "oxCBDjoHC1wNzdJapaVKACIkxKqHAFk5r2RwBJZc38bzoowHYq0kYrVp2CPJ" +
                                                   "sKyP+xpvDNkxglJQs9S5LlJhAS3HFQAxp3JuB1oAb4/47pzPI+fcohruBs3J" +
                                                   "a2uhUWq1F2EVKsME7OY8tdmcLoeLyzVszODJ6TIi7mUEEHtgUTdsYNCICO1s" +
                                                   "4PVmEnfSsob1iqwxItshYApnO0PwPIQGlsAA1K3FHViCHdkOw1iGKlTx5GAN" +
                                                   "GSg6puVRKi+QtWDnvGN0bmUF64kuc7B03T429mqg150x8llAHdzz0KWEgSml" +
                                                   "LR7soli14OQ9LYz5vCzLeu7N0Q2EH2xLL7IzauHnlbdMkTgWKRfB4EV70rdq" +
                                                   "bdCQu2ir8iD3hVzme/F0pICiaM9b5wjzLtbrYVRjPtFvMatBIVgNEqVJG3jh" +
                                                   "u4CWiWbTNgDW4qqUUCuVXp9Ehtd3zlgcvc2orkNdaiw14Ryzq9f0flsr0x3K" +
                                                   "CTmKsItmD9oMKWeHTdCNwnmli8eOCFewjVlODRyGMxFSspxHNq2zZLyZRKc5" +
                                                   "hCRVDRng1DGgIRTZgDK4IzfpmtsN3SGoa5vzUEcsAZQ7jEHI2AYBlocVsJf6" +
                                                   "1tuFx0K8WD7WiaR5OS2jWEVX2/1uaK3CqcLjyC8MCIx1U8UwyQIbd0TQy9ko" +
                                                   "2z1XNEIkkWZUNlbsOQuX1bwjvFrsAzmn/EEJvS4UWZ/ZrBGVjZXOiHQu4umO" +
                                                   "wY9ZXiOkQ2VEQWmVLKtBvUvCU7NkRXI5Jnor4xHiluERGi68MELDtkoGoe5O" +
                                                   "RlVdJidzXo5rGHW4o56LcC6o4NwGVJL0amQFFb699sLLoRxNGopyzJmcKkNJ" +
                                                   "Dzu9IyMq6NPNackfNtVlszDxRVg4YOR4WYhJ/d6DgNaVRBxeunaqb6BitcTm" +
                                                   "keIeI/ZSRYUhZT67EeiOutTbBD420Cbytod0CIpkzpmnvUA12RHV/coc+7oV" +
                                                   "0b2VQasNSSL4tlvLGZrHWIuMNJWaJA1DyIgMHZbRDePj6xBla19nbboJe6Fq" +
                                                   "ItMle/I0FPMgFBmEQCIKr+2lFB0crs+2/pk+AxgYpaG4coGdXwEKEE5+GU4Y" +
                                                   "UeGUQFqK2/wygIh8qRVyXTL7ph9WVuOaABZrqMyVIhTRWXQqIJbPlBFJGkos" +
                                                   "rEgGe5FABXxSqsl7OwDpNkAqGpqUplqHmOCNFi1VFbwM+gGNVITwSK7bWPlC" +
                                                   "KI9GsrTXMLCwtqiQ9iEIDqy7WEd2tFeAC3wSgUbrDegihpqpBb6B7X1dIw/D" +
                                                   "Dm+r7UVEgQ24p0LACTSB5Cfrw5IntVpwVccdaVlfyzYGd30vwaiW76pcpA+b" +
                                                   "ZXSKBjYHXD7rDv0yqneHisHT5WC2DY9KfqkQRRqTjCPbvHS+LLL9FEfAIUaZ" +
                                                   "MS3mwEBZcdYsfO600ddYKY2Bu55rCqBxXNGVbRs5FxTPvdOc7SFZ43YlwzjU" +
                                                   "RdG5hZnWpyXYrHTKO5EQ1lhsFNm4whE20DqoCy8P65aI6YiT19V2ATe0CTTr" +
                                                   "cQ943KjvlutFGGNcTaOxEywOx529K5vOCJfEsu71BUNd/MXGY4U2t0RxF86V" +
                                                   "I2JUh5rV1HRlMNyk3NNlLF7IPUAtzJ4zRL4/T6bV9aMBhzbrJUDyIpNX+ZZD" +
                                                   "RWHvVsF5e4y3dLAhfKy1+hV+vKxNfCfOUaqTDksDP1hEkesy0/r9btjp63Nj" +
                                                   "HMmkhQDCS7UjTp8nALOu3uAXtCZUhuHFCwYLwanH9V1Sye50GZNSfCgicied" +
                                                   "C4OZBJLAHQZHNriaAsOcUEUqy+1OxhdntVlzZWPjPJ2nDsGIAYnFSr3rYyr0" +
                                                   "aFQWkQBTcIVAO/WYC5KRXZroCsMkEGx56dEdHnk9bWELKMIUBdtl3BHceiYf" +
                                                   "oOG2E8BWqDeAp1VFEyMnRmrIVDOiwXMriu6bvWAp840wJAdO9gHfE9bL5aUF" +
                                                   "dnOEisqNM7KydJzikgXRqoBx4RxmSwPzLCR4oRxMyDiT/NnsFd4bj5vlEVZJ" +
                                                   "H1CD5Up0YoOvzgrrgWcHA4p2l+2x/bDZFotJqdqRK/CDzCf0aemHxBDFm+qY" +
                                                   "bphJ07GBytLjZO9p1l/ZmABmlrAGHCWJYNCxklGQJ2S2g3YNNQm5A1uuLtdO" +
                                                   "hA+tPelwCMfr0cy9hqFLfLNUpL3g59zeVOg57F50gl1giUsB4mTx49oR2DRb" +
                                                   "KMg+P4T6FMwmPYjMM4OSDrlz6h2iXeApEK5MStzEcA80Qmunq6U70UveVWju" +
                                                   "c8faNUbBQJGqsBYqk66FJYDIdFO2K9tY+O0FVoDViNXMgk4TU7aRs3MMJ4FN" +
                                                   "mJjC6YAW0GUGrFIeYNBxaI9ndhwONDlFziMkdvudo6ZTtArpkbIBti1NrI3J" +
                                                   "O+0IvFZCqPEXBdgM6ATz2OvHrbbGD6vgkg0NHeRyQ1vUAs93Lq8ck5O0TXNE" +
                                                   "ZDiCNKlDejmqqpHV56NgkqYsbQgWIyf+pwQmduQO8DcZxHFTMKRgG4+abxLA" +
                                                   "ODFBp/ubMD/5u0rgQgqBx12RgfOiNlRmWBVYPzgYAmyKnTsWFDuFx0vqaLFr" +
                                                   "0TG5VVt1KL1OgoMVl80l6H033/SM5cGWYS4tP/SMxQZMNL45Hvo4LjbqEbOP" +
                                                   "XuCILYmxJ3nFEH2w7Tt4f9nJVrXXTKamLW0ypoSUbXXQFEF9CZQHQh6ANTzx" +
                                                   "dCX4JO9JZg4XbLU0+V3FGKeKJj3cqMZBHmuWzJGAS+xQKAtBNopQDqFwuXTx" +
                                                   "EfTAXpVBW6KWA+LXaTCgbn0g5tER8hs4o7y5nKDBOvM8K9HjOHPXBHRZ8jqI" +
                                                   "qE6pj6vRzd2MF1tsQJvUBQTqItbSPNztipbyosvxaKdLdKilqJ6iyK2/j6Yr" +
                                                   "yp0rVYv6Yb3jF1GIUKWLmuhYhU2RjZtFD9sAImSQT4yt2BteIeFmrWyRPZIj" +
                                                   "pX9gAsDehIbkdYC2HkheW0VciwjWsC3cZRMDk7NeEvnp4HLR6PFHCygMj9sZ" +
                                                   "OtEMVeAR9aokQlKBCzcFeI3MNTJgQm4xoXQywg1VZjrgbVJADkyn702hjc35" +
                                                   "ijAV+DQ36FoHsKOQKcQUTBdCQVBJ4R5dvTsugM5PzwIhHDPiZK8cTz1MpEs1" +
                                                   "x+p37GJ+ahvQdLtGODu1GVMl03eNC2bK4GyhkZzsFgLsKZ5jmsVlK7BROtYx" +
                                                   "dNGG5lT6DCecipUrq4uGOrtHJJRAthBz54hXCO0tT3y+7KHJVTDsrV2u4iBd" +
                                                   "VVpD1Vh3rDIDm6sl4EBAsVgmzuRXej60y5lup/XKTseHfFvN6XRThOOWF4jL" +
                                                   "fiMt8UvenfX5mWn6BRp5zJzqAZmyz+cib/yIbMMe605o2LmoTx8Xk0Ge74VO" +
                                                   "Q6u6aYJguyKoGt3k7IHcGFNQsYdhhC5I");
    public static final String jlc$ClassType$jl$1 = ("K6imeH7cohdjXjfDsj8sDCISZLhKHKd3d4G0KBw8Q7fqdrlD9wW+X0i0pJtG" +
                                                     "I8JTIL+vXf10qPHlaQe4Vc9GNRRI3VkjUHsu5nNghzLLtRsvjfOkVnjiEjxD" +
                                                     "w6y0LwV4TgaOXa9zrulkBvNWzZLZRuMUNy7hRYXyyfGU7JQIwxT7pO8NslW3" +
                                                     "dT9WS4Il3LDUaDshjC0M56tmzi2j9ADN9clPcxRgIR5jcn05KzWo2QnckA3d" +
                                                     "Uj6SOQFVN+t5UlKeUbvm6rI1s+asAs7aBkawBNEF2MCKvTdGVE1PJyQvNV62" +
                                                     "Qi8DrCH3t0OU97JzVBept6lUfgHQor+I4d1GJcCFvxNZhqmwdl2TJryGY8hM" +
                                                     "tkouyMvLZisxmQPBvDZ2C9FY6SO4gp1EQDV3jV2ipXKAFxgqHLYGEWPsfIIr" +
                                                     "XF3MdtOlkuXGwsrhXLjoGqPq9X1r1rAiMAezLeK4PTOVvT7JpeLxItZRvekA" +
                                                     "umRqIDeswnyIz/iJpFCJoPlVpjcEe4qlZqPAkyaWUV8KXO2uKmlZaVI6mLwh" +
                                                     "8FSOqoG3X0QNW5vEsPBJegebTLjLT7xIMLUE5Vh4CADUqS+jONrHmB5cSHBi" +
                                                     "WDM531ujPACMGBkzey0a+dGr0WWMT+EHRlAYLEtzxA2Z5rzrznKxOiws5Lwj" +
                                                     "GmNuOq48LubTZVFtda9DShVjs4SVOXnkpsgxl000NS+Y7S1bJzLisdW6LXaK" +
                                                     "FhZn+zTUxcMZCuaOtzPFoVWTDF5BWy3VTWUdCMEyWgNzZdHvobkwj+PQmIMQ" +
                                                     "zZHpCdc5vp3PPelSNEvQw+s22h18pd/EG8RJs7JbtxfDHMDqcFDOq1SrvATY" +
                                                     "DCwmLLGAWV52sYPQi2WLjVywYBvNsUcvFUmiR/Qsr/CV1qNHAoH9fDHCDrfk" +
                                                     "iozdjqnad6ITOXrK1H66V4bl0UZJeagSTMUlydune7XQMHegTHpHcGwelAi7" +
                                                     "myx1h412bQurLcC2iFKwaB0hJQZKR5UEQCnZQx2LMLvTWaQMbystLkFmecN8" +
                                                     "qXU2cKw2++48bkWYiRD+XAA7NtkT40ZI8GC+M8+L01Jfpt4C8+RLafSgQ/ML" +
                                                     "d09Qou0B8nEOHkxtR5oSVpZrAhNap3PQyZPZbm07Ia2dmVnyUTjQkshhtead" +
                                                     "jltqZ+5WgxiNB2yeDQfRSBfmhuTz9NRvksOI9FIy33vsZsJTGNZXPNuo17RU" +
                                                     "C3Jy2dvjfjJQ8BY4tYoScBvKtJH4zADhkTpng0Ey/R5dlHBob0wy8QULQyl9" +
                                                     "AysaEMlnOBKBSs/pKq8ve/XIKtl2DdRoJHY57J4EN1gh9hSg4AOxXvhC79DY" +
                                                     "cgAtSF4ZHCHiK5Y+o0191NMBlzkE36WWvySrvSDIjqGUF3HTXTb9CBBguk5p" +
                                                     "E1Eoegp1Gc4wqpipRv4kHQ7r/f44HyY/qpifKUxQiaNpsqE6cRS2g5iAPbLB" +
                                                     "k7nXBoe1QFNwkNU9kC69VabsThurn4SAuTjKxZW4Tm0DiJa9FjqntEcmYyFp" +
                                                     "urTPCzOU4GA4aQcRUYtVDFIXb6cc9too8EJ6NJyuRfyOSaVyuyFj11/ivEbg" +
                                                     "Bsn1LUtOwns0XE2qwnWHsOXCUYn8MPk2G+Zss96SaqWVeyisyT9YUn1nismZ" +
                                                     "2IZbXUOEirjog5g5k5Xj0wUSsBkgLpiBs/bB/hjQbOQdluIkKIRFlifNz8Qj" +
                                                     "JbkhhxjLDZUdo7m1rzt4CWR1Q1K4UtTuAdx2bN04k4GgsgOLNU7HldvTHnOP" +
                                                     "YbrenJdAqp4pFF8MMNnbpQmqVKwHSx+VdoIlsgLuu22QktXkKVmaIqI4wsAa" +
                                                     "PkB+4usOzjQdfCQbIDv68aW19p4v7SbxrsXJXZ/8omF7Rk7LKTja+zuT545M" +
                                                     "a1Z84Z71EKC1Sy8efasBKgmNoRW0usSGabV1mJsTf8ST7OQXOa24/cmTIfFs" +
                                                     "WOdc5KXwssT0KWxsG7cPKmNPUeuqKfAkBBd6LBmokTWT34Q7DsDT+z6JHbaQ" +
                                                     "YcpxCKraMw4co5suunSLo5Xk1AmKt2cRTqUdYIHGsmj8tGkw4JzCBr71V2cZ" +
                                                     "vLgc014YYUUQLJ9FTdtReryUHFmFYvDid55wCaeYX3Wlgs83rp1vLnLCEGcr" +
                                                     "ykXJzBY7Xu7BRKLGs4rt03MVH7YJBKtYSFkYoYHsaj0vPQ2CCQWqjiQzH43N" +
                                                     "OLnfXFtWOdRyXkxsJ394o7oyNfLwPEFbu/E9Dyc8BEPC7HyIOtVhBDhrxFis" +
                                                     "9VSTpzgfDEpgB2coZY/KLvK9kgdzcX72GtZJaJWh2NFTNGRYGHy+OktEQUUF" +
                                                     "d74YWNPl85xiVuEZYrpN0hxVB3d1eLn1tCCWCEKNWMMbzkMhhxxJLvj5kJ7q" +
                                                     "Mwrrp3HDszziSQpJNXRMJWsedNVL0AEToGCQe9uOi3cXkJY5WuWddTOUR3JH" +
                                                     "q2GJ7kaS5qRdOtIqUQPCZrtJWH6zUC+ugyyxlMnDCljaUKQE4FzPEUZlyS4Y" +
                                                     "NuG64BfzyyZTl9qk6HKB4A6ENXFXHZdHyUxcZzO5wlxlRjlHoiUEn1R+NV8d" +
                                                     "bGwHCA55ptYmQS3idU3bvs2bpHY6WIja4LVUnrohX+c9UEIlIQnRRaI3uioe" +
                                                     "R6bBYngv2zwEHluTYdDMBZxwJ7VbCBIKdx473pwe1w675WDlgJvNgmAbcr3Z" +
                                                     "tTghLLRDGEIVMMWrGysdlvNqt96iKVAH9eRTixp3kKyMOI4XSB7mbddupNg6" +
                                                     "4nwC0l0Sp1uTpm0J8dRzZW+UIXNCZckd/XaDaKnUYnMyBkEs7Dz1wlORCeo+" +
                                                     "JCuLPSuXyyoWB+5I+oLp6OZJJIC8NstG70FamyOQ7komNwWC+cYCUs2N8UVx" +
                                                     "DLGjmhOqqnLBUO5FKSC7PS8ojl0YEX8eiCSRGMLE/J5zqV1+JmpTIuwNddyh" +
                                                     "NTs/dMuVZ1/4U5cpBjU3O8ZC8L3Vcoi7g3WAOaopgrnhGOYbct8fz6aNuQSa" +
                                                     "IDd5oDRca/XmbBJWuEKM1YHIKmktWyisdkFajQF/qkq3WAgwbl3qfrEyJ213" +
                                                     "LtR0oao+Rs+HcA94u54O2Tneld5lYJvLYeNjl6A5dX5c1ZBknGsVxCo6AvYL" +
                                                     "HMXkGttK9ka+pVH9G/dZBR+/5Tw8Tu2PQv868EdelDjwKmUTJnFO3b4AmIGp" +
                                                     "tPTYr3dVXbssM4npyuNVgfWYCIvP7XGbn7Bcc5IRXdIsMbmfcdlzANCe7IKo" +
                                                     "e812FiERlj0WT3ENY4LtuT2b3ihvPGC5Fk3ET6uKX8n0uJWB3I0gTHFP1imn" +
                                                     "Duoh9zM/AVPaIkcvSTW7s0ub8ODF2TucM3vp6kbWWmEydsyBQkicWuSHDYme" +
                                                     "Fhzc2jtes8/cJcq6cbL/pLcGSP5inj0CmS5JiPJ12Nm61PbiA64QoYEVCtEe" +
                                                     "tTWHBtm+C0BdOwxnzDuRIFWYrbOXSDTCVLUFDfwg9lCHQs4RpQSWdNUY40dz" +
                                                     "rMSO0RJ4lZ+mqB44JBdeR3QWGiPPy1oIFjebVmrWnkMQyw4HZBxZ1jy6pVoj" +
                                                     "IVJGmzy61q1Wdu8JSq8fzc2QBU5aNMm5MjLgTBHWYJgmF6W2MGe2zA6kwlWq" +
                                                     "zEmhrPar5Sge9DE2lyMJD0iSpbK9aJjRsPtu8jOWrZGenfnWcua7RPA4q4VE" +
                                                     "XztdrAR2g/UBuEDbihsXil/Tul1ZKE4De7BZ9540+TvL0lasvKQDch2C0Xy+" +
                                                     "knYrs8C9yaRmJ2bd+qsh2kIr/4yBU4QoCvzJ6ffJJs988bLYSqujZ9jMZfKZ" +
                                                     "Lm7NimMNermMZeCKhNDNgO7FnWLTCAtOd4WuAHPSXyZrfbgESikLA+DMmXDt" +
                                                     "rQVTWturOJu8o4t+tPS1FcdzHUkGs1XmRN4baaLpyKVjgSFaHZ3NYhwdXIYG" +
                                                     "qljLAghxzLBdg2IExEC+8uboRVBsRjN5UVPgrmyPiu+SwDHangpqp22Z/eJi" +
                                                     "UmA+xfVueNHdzl1tVwmNk+OSAHjSKaEImSN6oClOUzoIABwu8BzR5DlKIom/" +
                                                     "oCECqHehZuM4/l1Xdfrxe+X7uueU7w3oHdTvLqHqJ16SEIe/LZfpm66b3RLy" +
                                                     "ns1Zf+twnfIdtyP6Jwla3/o4Qev2e/3+CcfP3Nc/9VSC1lM50bNrYuqn3+m1" +
                                                     "zS0p9Wf/yFd/xj38e9CD+8wzppm9v8mL70i8i5c8tdWHbu34MRgffPSiZPpe" +
                                                     "/ZP39Q8+nWX2hErPYHCD7AP3S/7off39z2Lw4sS4f/clYz97LX66mX39lbBv" +
                                                     "PEvYN57AE789V+4L0/f52ew9r9/Vr/0PL8HiBYly1yV//77+e++MxStPkqu/" +
                                                     "fNv1P3wJKn/2Wvz7zexDbXGuLNe7pWTelr6IDQ+nj5oE4Z/c13//3bHhuuQ3" +
                                                     "7+t3g8B//BIE/vy1+IVm9rHAytzEeyp7+EXJcJc8dF+EGDB9X5649Ofv6594" +
                                                     "d4hdl/zx+/pHf2fy9UsvGfsvrsVfbGYfmbzXZxAyXgT9NSXbm80+/Mfu6/zd" +
                                                     "QX9dkt3Xwbtgyy+/BIVfuRZ/eWLLFQXvBv9dfuO1X3yRclyz+CcoPvIX7us/" +
                                                     "9e6U47rkp+7rP/4ukPjVlyDxt6/F32xm33BN251sWegP/1xcbgz57PT9+Gz2" +
                                                     "iZ++r3/o3THkuuQH7+t/7XcmTv/tS8b+7rX4O83sE5NqX19a4U+yaq8j/+k7" +
                                                     "idSfns1+z/q+/pZ3h8F1yWfu60/9zjD4zZeM3QzlrzezT9Zegz/38uJFSNze" +
                                                     "IX77ldWzu9+tbma/9vwDsYef+xf8Puzz3/mwbK06LNu88T539/Dq4dUyPbxe" +
                                                     "1mF2yWOP8vynnuV97vMPv68JwvrNF184n/v8F7/y+aJ4Z77cfq8/S43r6P9c" +
                                                     "FC+h+z98ydg/uhb/oJl96p2AfhFbri7E7d3QM2z5j/7lY8vdq6Cn+RI2Vz48" +
                                                     "/J4vyw9fRO7vfju53/sicv/vLyX3//2SsX9yLf7XZva+R7C8iLy3wz/9HHlf" +
                                                     "+c//pSPvXdr9w3vhv39zdKPzo1cQuf+577k97Lj2fp+V2l+5pcnftR6/37v9" +
                                                     "eVt3+MLD++nWxXp2/t0rhrvJ+ZfpiY2h//Bz+cPw8WEPn4X+yupn+x46D7/r" +
                                                     "4eeem5l/8eHdG42Hzz8wVK9PFbyynaQpmUir5J9z3nyJT/6FGyqTPt9v6FtJ" +
                                                     "7T2n3S9+CXMtfuD+BefbBenBk1k3h7++znrlwTuL2yuvXTv/6eSCvJ0l1176" +
                                                     "aaF79PT2U4+E7VHHdfTTvxtQf/AlUH/4WrzezD5zo7BVNy8m8w2mfnJOnh24" +
                                                     "Pi/91HP/z8Pd/0bg/PzPfPR93/Az6n9996zr0f8Y8Pp+9j6/TZKnH0w+1X69" +
                                                     "qDw/vKH3+t3zyRtJXvn45IxeYbu2P1HcYff/AZqB9NNpQgAA");
}
