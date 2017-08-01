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
    
    public int getSessionNumber(final Paper paper) { if (this.allocationsVisible) {
                                                         return this.declassifySessionNumber(
                                                                       paper); }
                                                     else { return -1; } }
    
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
    public static final long jlc$SourceLastModified$jif = 1501546578199L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAMVcC3hUxdme3Q0JCRBCuIVbWCCgiCaCiGKgXBIQaIBICGpE" +
                                                    "w8nuSXJgs2ez52wIIK1aFNFKFQH1UVGrtEK9tb9oL16qlYq2tVgvRft4+e1F" +
                                                    "WkvrHa/1n++bObc5syeLbX/zPJk5O2e+uXzfO9+8M3POuesI6WWkyajVWmul" +
                                                    "uS6lGpWLtNZ6JW2o8Xo9sW45TWqOfXzbr+PXn5t6LUzym0hvzWhMGkqrWkcK" +
                                                    "lYzZrqc1c51JSupWK11KVcbUElV1mmFW15E+MT1pmGlFS5pGJ/kGCdWREo2m" +
                                                    "KElTU0w1Pj+td5hkTF2KVtSW0M0qtdusSilppaMKm1JVX5NQDIOWlI+pViG9" +
                                                    "U2m9S4uraZOMrqMN57kTSouaqKrn9+rgV3V3mkSt4nn/WOewZNa7HZOqtl93" +
                                                    "QcmPIqR/E+mvJRtMxdRiNXrSpO1pIn071I4WNW3MicfVeBMZkFTVeIOa1pSE" +
                                                    "tp5m1JNNpNTQ2pKKmUmrxjLV0BNdkLHUyKRoE6FOK7GO9GUqycRMPW11J79V" +
                                                    "UxNx61ev1oTSZphkiKMW1r35kE51UUTVqaZblZhqieSt0ZJx0IUgYfex4us0" +
                                                    "AxUt6FCpveyq8pIKTSClzHIJJdlW1WCmtWQbzdpLz5ig4OFZC60GQyixNUqb" +
                                                    "2mySMjFfPbtFcxWiIkDEJIPFbFgStdJwwUou+xxZMmPrhuSCZBjbHFdjCWh/" +
                                                    "bypULggtU1vVtJqMqUyw7wl1O5UhD18eJoRmHixkZnkevPCd2SeW//wAyzNC" +
                                                    "kmdpy2o1ZjbH7mgpfnZkzcTpEQZB3dDA+J6eI/jr+Z3q7hQdWEPsEuFmpXXz" +
                                                    "58t+ee5Fe9W3wqRoIcmP6YlMB8XRgJjekdISavpMNammYYgsJIVqMl6D9xeS" +
                                                    "AnpdpyVVlrq0tdVQzYUkL4FJ+Tr+pipqpUWAigrotZZs1a3rlGK243V3ihBS" +
                                                    "QP/JKPrfm/7v4/EtJllVe8bKRkNNz6elGCtr9VimQ6UDeGVjUltptquGZqyM" +
                                                    "KYbabJiZuEZzUERzreNlMx2QK410DH+srLFvNqwzTLWjkt5N/T/U0Q39LFkb" +
                                                    "ClETjBQdQIKOnQV6gjqJ5tj2zNx579zT/KuwPSC4hihWofRKsXQSCmGpg2DQ" +
                                                    "MKNSk6yhg5s6vb4TG85ftOrysRGKptTaPKpQyDrW41xrHA+wEJ1hjMLwuVmp" +
                                                    "VVtPHTEjTHo1USdp1KqtSiZh1tfM1TNJ6kwG2UnLVOpnkujdpB62IBVDGZMM" +
                                                    "9flG5hOpWNopBMRGUOhXiANQ1sz+mw9/eO/OjbozFE1S4fMQfkkY4WNFM6T1" +
                                                    "mBqnPtMp/oSosq/54Y0VYZJH3Qbtm0l7Bl6oXKzDM9KrLa8JfelFu9eqpzuU" +
                                                    "BNyytFJktqf1tU4K4qMYrwdQK/WxxgL9j1zH40vh7sAUhIMYnsDsQi/QK89s" +
                                                    "SN186Jm/nhImYceB93dNiA2qWe1yGlBYf3QPAxwULU+rKs33yvX11+44svk8" +
                                                    "hBDNMU5WYQWENdRZ0GmRqvnSA50vvfbqHc+HHdiZdM7MtCS0WLfdSUgnRbxz" +
                                                    "m3j8DVcnaW0TnPZQp5Ogjo8216hoTHboca1VU1oSKuD8s/7jJ+/7+9YShoME" +
                                                    "TWFaTZMTey7ASR82l1z0qwuOlmMxoRhMeo7OnGzMkw50Sp6TTivroB3dF/9u" +
                                                    "1A1PKjdTn0z9oKGtV9G1EdQBQaOdjP2fhGGVcG8KBFE6nMWbtLoRzqDFwUN5" +
                                                    "g8ZIRXNsyLtjq1Lza19HexeBm6BcSYtRFjTSN+Zq7Lsw8GDubrMyj/JlXujc" +
                                                    "hiEzVGwDrz/v/Gj83ejY83Cc9ImrRiytpSxgUU9fZGgdqQRVtxrH4U05hqkv" +
                                                    "ouqzCVNaSRoJOsEwl7Acb87rTqVhuu5S0mgn1Mq4bgCp3Yx64GHNsdOu3JzW" +
                                                    "x10xLcwVWQzBmG7KAuPMS0VTsWjCci9nAIyxDKtaR5lO1c2xmwdf91DpD7bN" +
                                                    "YXPxaK+EL/eMk2sua576w98g6AEg5aK2lqkK9fFMnc2xd3e9rC479eN/sEGq" +
                                                    "r02K/DFFqU9MSynAIfkVUM80lgL9mE1bVeaDBS9+2lW33nvk1frZiGWXAYAg" +
                                                    "+Dgqt7BLdRDWeOcKuz2Vy/WU3aTm2AVDDk4a+dC5W9xqEgRcubfuuangnyd+" +
                                                    "fCt224bBOAEGtkAgFCCcztqLvsJjIHcj3XYaOviV5w90LfgHa66IA5nErCmD" +
                                                    "HjlcNmwDtyxUWMtrhWiB1Nhn02WIY+xoZd3jjxYse9plbLQgVcFazMjsCeEc" +
                                                    "xwBLaMHjZfqcq5um3uHS6sxxL6+u/vzZ+60BMM/WykRvBwVJdzfzT/jZsK1/" +
                                                    "uGipVcZC1tWlrq6exZKmprrRQzfirxkGeAaBfSxQjHY6exxK/L5pxysnlDNl" +
                                                    "u2YXfv+ntZfu2PnjB6cygtKX+rqSWbMJYU4PCp+VwrY0saakPM0Qfi5mWZuZ" +
                                                    "gVK2cbw/WVyGjhVWmiM9ZGg+LH0cAhBbP/Mv2/7VSQlApIkUtyvGwiSdMGGl" +
                                                    "RRd04D3tXyYZ4BpW6JaABiTclEZcHgiVNVXdddPwmq+9hSPWYRsgPbrbTxtX" +
                                                    "KC4iNGVvxwfhsfn7w6SA8jVkYXRVu0JJZGAOb6KLNKOGJ9aRfp773gUXW11U" +
                                                    "22xqpMh0XNWKPMehq/QacsN1kUBt4J9MYhfheTye5KY2IYIXa1BkLIbjITge" +
                                                    "bRaGy4kmrVlLKgmBTZTw8k7gcbmrXJMU6uk2JalRnm945jJ05WqcLcB233nX" +
                                                    "PdV99+zGkVqI9qPWNPm81RskrN+sa/28XYvyqs+QdY2NHltguExgqlsAowwf" +
                                                    "ZhCeLR0kdokjIHE0L2k6j08VieM62v8KqZ8G3LrcykitI3PH+0/XIyT74aaH" +
                                                    "ZXyTDBMB77BrdEHeRo3kjZkma5Thm16xQLd3OlT3+a6ZLz6yz55ehwkswBkM" +
                                                    "057aG/ntipU3MxO6aLt75oOVj2vrgO9ZlGfrE9uywI612x0rh45N5EvVx3j8" +
                                                    "gLtjhGF5kxzLEY7lfAO3eOCXzhH9Bf0L0f9/wT9UAwkQ0+Faw1flUXtZbpKO" +
                                                    "pRa237hs2xtX7D7jP7miXUz1B6vYMyaffOKUaSedcjpdjYaWGn6PRqHTQV1i" +
                                                    "F9/wUC/ffsUXlVu3h127QuN8GzNuGZea+0GwBaAxJqgWlJj/5r0bf3bnxs1s" +
                                                    "min17nHMS2Y67n7x819XXv/6U5JldaENf2tNNTILsrCqsX8s2Lzw8KLdOCWU" +
                                                    "gFtFUkL9KrgKTFqY9Cb10Qx7TGHXroHgWliM4zTmxZM4ek/3ORBrvoOgCwu8" +
                                                    "wZmpu7xTpD9psEmKcSfBRgz2m7hcjWq3CJwNOYn+D6Yt2cvjLRJvfasc4XTd" +
                                                    "V0D1SymeKrjqPrywy3l8scdVlyqJhB7D7UxjhWZoFudLe1s2jAvvlLVMcLYD" +
                                                    "ZQJX+5ztntyd7SBILOMl7eDxNaKzvRvzb/BKDea5t8mkMOs3XY7DQchQWZXb" +
                                                    "AxGyF1uxz4HDXj9CvElX8ZEH0dXUgC26nlCVpAsme2QwGc/aF36Oxz+VwORh" +
                                                    "BhMIbvfjAaR+wuMfefBQTMdwQ6alQzMMgIQMC4O54C9k1QtY6C8TeNiHhSdy" +
                                                    "xwIwDzQtlPQ4jx8RsXBAwAJKcbuGH5VJBWBhoKzKxwKxsB9bcdAx/H4/FvYH" +
                                                    "YSGiJU0XDp6Q4WAqg2ikkMXh/5Xg4FAgDkDqdR6/5MFBHyMYBMdxqc9kdQsg" +
                                                    "GCMT+NAHgtdyB8FYSJzAS/qUx0dFEPxRAAFKjeO5P5JJBYBgvKzKTwJB8Dq2" +
                                                    "4i3H4q/7QeAkpclwZzrENQTudrEJ/slTynZsvvboUMq0mkgBX2PgamOJnsQf" +
                                                    "kqMUl/zbd7321u/6jboHN47yWighgVqLxDMo/xGT5+QI+9PXC4Qxlj2zAkFA" +
                                                    "zmie8f0ckDNMJvAPH3I+zB05uBIo5yW9x+N/isj5REAOSo3gud+WSQUgZ5Ss" +
                                                    "yncDkXMUWhEKOzA56kfOURdyvKe41H8bpusc7ZzjVzy2aZhxJSNtE22UqN1m" +
                                                    "JS41uKgo99KhyJQ+ZsV3kN7boOlNF6MG5DRJNPsJLpbF+GUfWxN48lRK//Pp" +
                                                    "/yoeN5qk8T/JoeuVlJrmx03/nYLROEUWx8Nt4Eq8iadDPks0xwZMv7Gl9ZLZ" +
                                                    "TyIp7o/KQ8bawNQ4wbta4kIVDd583iNtqe2aY4fvverAmL+tGIhnlZaZ3AcS" +
                                                    "i5VUtXgAAVtENL1XwcuP/WLIqmcjJDyfFCV0JT5fwbMcUmi2p1WjXU/Eu1N8" +
                                                    "YIXWwhIsTCxufbF3tqzgxk3zWAGV9QW4h/rxtVpoaNBaDYLLIdARQ1vojDQH" +
                                                    "nzlAhchmTHsLKMT2QICshcpJiAg+BfCHzA6G4REevyn6lFA0d5+CPR7KS/o7" +
                                                    "jw8LPiVUIfgUm1VA7r/KpHw+pdYWHiKr8i2f8ALHp4RwpzN0ou1AQmN8PsVJ" +
                                                    "6u727lxkh+Xk6tiSx/XpExHb+Wa7ZlScjOc5EkhXM9UOwkqqEEV5NoLQubzH" +
                                                    "eUvoVDk4wjY4bFzkJ9Rkm8n2CtKsDNkpznLaMn6KsvPDQcsuOfujRvRr4Rjy" +
                                                    "rNF1pHdrJpFYYq9YITyNlWeS2VhIVG+NUrcRNVJqTFMSUWuXPDoW+j02qiWj" +
                                                    "6AfO27D0jcu2bTwfozeu2L3xvPNT9g6zvfNSoySTuuk73siPafuOVLV+bu0O" +
                                                    "z2T2eZt3ze7mB3j3Q/RFEEzFvR3pIdy8jpSJx2brfzz0/hnf3/Uq7u34rCDO" +
                                                    "I4tx6ne2e067rbZi5OOdW/9zZ9Xwc4T8WHq0QGbExuxZfNdTZ06IbQuTiL2H" +
                                                    "6nsQxitU7d05LWK1Lvfsn5YzNYNCZznUeQJiDX9LDxRDiwLu1UFwJnVQsYSe" +
                                                    "VHs2ZiqVCoUI8ZXF/Bg7EQid1aN7wk360HLmOLJt0jP3wLKey/xAtq1/CBu7" +
                                                    "YaOhLBvIIcsLqDo2iHH+D82FoIaE4C5fzrwmW86czDhWpIvHy9zujLuF5sDl" +
                                                    "DEidxeNFLmk6ebi2OQRSWmD5YZjQdvP4epOcXtWud6hVq9V41Vo9vaYKHFqc" +
                                                    "jiG8SGgtJ1FigNc4r/I5lPOOLy3LjQxdXcUM3d6joVlmCNc4nnyV37mv8vFM" +
                                                    "LpY1jz8pVACBimIZiwGVgNdwMwnMWYLhYN7YCPIFdOECX8C9uPFc7w/w+F6Q" +
                                                    "bUUFtFl8YX0WvmA/8WDv7wqHFse2xZuCPdcVNsMIXYydHQVBFwSjBT4B++24" +
                                                    "tATUtfO4xY1dbP2lufMJXDCM4SW18TjmLhEK3CLwCXuZAbnjMqkAPhGVVdnq" +
                                                    "E3bzicuwFdc4QLnMjx1vkmNz2BFCxYGt7+bx9yQ235mdI4bgCZbQNyG4CJty" +
                                                    "MbXb1+FiU1Zb4ZbgcN69VTxu8tnqxtxthT0Zxktq5vF5oq1uEWyFUkN47pUy" +
                                                    "qQBblcmqvCDQVjdhK77vGOYmv61ucnE/+D0ZAvb4E7NFe7drQrRbg3/53IS7" +
                                                    "LPfpag3mLHOerxmV7YFP3PW/45Ltu+JLd0+22M81Jl196KmTEmoXp/2sqAJs" +
                                                    "o6MUnEFOJHhK1CufxXl/EexASgKnDxD5M49fFXvgzO1u0upMI6dAKfN5A6I8" +
                                                    "7ueximeHh7HSOek2Tkrv7Lf/V0fK5h/AHZpwTIOnhHzP18XVbFwmk6JTsptT" +
                                                    "hbs0uFrNeKzdzNmyZg53N9MkF0C9HXo61a7xh3mA+LJn66JKug0X0dEUkAC4" +
                                                    "wXaIoplUW1qJq8gNose3QFPUeFRp0bvUaMu6qE0TJrLpgdHaEDzfEdrHjAOX" +
                                                    "DwQpGzL8jKHzIQgeRVj/HNH52Fdbnv+xgcbkmqS+Nsm2Uhr63JX51sMnHbJg" +
                                                    "zc/csL5nArjj7yC43yR93dqFtIMygih5Ooa3goNsUNXfb1760Rv3Wc04jfUu" +
                                                    "5THJC0IinU3R1g41eZS5yT/k7ibnQOI8DrfRPB4huslXBTeJUnN57pEyKZ+b" +
                                                    "dLbdamVVlvuE3XSI2f8vjk981O8mnSTxkZY6SjATzgJl+bef/P20Gw5vw4Vx" +
                                                    "8PMpgmTijsSTde+ve8ayknMOjk6mjvdlgszJcJ58RD5vIge3V84us/KhYFuV" +
                                                    "8bw+mPBep7WnInA61x5Qp72f40y2cK5KZvFGDuPxQHdjsanHsHkLT26Qr/GS" +
                                                    "yng8SESRuHmLUtU892CZVACKZsqqHBqIIty8DTubtyH/5q2T5J5s3/d5Iiio" +
                                                    "N3ojqXrgzuMQvIOGQ8OjxfDOU9n9SrgP+hUInhPmMXuPHmbBj2UTqWDmYTKB" +
                                                    "90Qzh4tzN7O9Rw8lfcTj9wUzh0sFM9t79JD7A5lUgJlHyar0Hw25zBzuj60Y" +
                                                    "btuUJohmdpJA00VE8ryxV5dAYMgUjrK+PM736fIY9ibhkQIymZfESU6vAlGX" +
                                                    "4t4kSlXy3L1lUgG6PFlWZVGgLnFvMuzsTYb9e5NOEoSNlveSAf+JAOCfIgIf" +
                                                    "EvvhreJsRkKV81rzsdbjZNX+JKDa0/+tagWuiy8tRAlOcb0/4fGfBZu6ua7D" +
                                                    "1u1XAUDkTzw+Zq4LZ7noVql04SAeh0QLhx6yBabKBIrdAiZp+VKss11JxhOq" +
                                                    "88TCsTHP8Ayb2YVn9sAUw3MdphiuRevMw9E4/ystD7IeROmGAPw1QlBtkhJR" +
                                                    "X53ZuGQnZ4K0CX566E700UPaGezH+bl7qVMhcTrHxUAe9xe91CrBS6HUNJ67" +
                                                    "RCYV4KVOl1VZGuilmJHaHZdU6/dSnqTQW94hM5tXM1w2ZBhzC3d8CeZGoYQK" +
                                                    "R1/kAxUEBgIrG4kInwlBp1VGuKPTcmrhJQGg6kJQQeBsl7kO5PK6dC3e85wH" +
                                                    "jgwfrACNEMuruTWDetmQO5rweZPxvKQvePypiKZvCmhCqbE892cyqQA0Vciq" +
                                                    "/Fcgmi7EVmx2oHOhH00XZpvzfHZaGGCnrY6dIFibZa7Z0ClOcb5aZgfUsu1Y" +
                                                    "apHNaJDzfEpAH+DxNsFiPcxoIHINj690iQY0+YaAezdCsN0kxW2qmf2BOHsq" +
                                                    "hlq/L2u4gPbhMoHbfGi/JXe020+iQ0nf4/F3RbTfLqDdflQcct8ukwpAe7ms" +
                                                    "yt2BaL8VW/EDB9q3+tHuTXrbq+Thlq6yKhnHxQ9dJyh9KKsos95LU+BhqCg8" +
                                                    "xGK/nxb+nx613GmtgsMP2u2kCWLThaTFjthDuYnBDzj4g5eMszhMKG0HjgMc" +
                                                    "ZI/n0nYmEN6PCbUsAa+tg0B/0mJH7GnHNDv81trh8U2yAQ3+UCWk3xYe68c2" +
                                                    "oEEkyeP27ANaTlFxJTWLS9/O46tFzLgo6nSZwM1ugS9LUcGBqOg9lmTggxLH" +
                                                    "SFEPOhTw2aCuQ4YXXZTyENrwJXQnL3+l5XXaFPXNAIf7Vwh+SymqqK/OHinq" +
                                                    "QRlFPRhEUQ8xN/tO7m7W3nsCXHyXx7sERIffF9ysvfcEuW+RSQW42ZmyKm/z" +
                                                    "CbvdLDPSZ84oPeQfuJ4kF0XFITOPV7NHNmQYRY0wgBwjRX0RW4YbVUU+UEGp" +
                                                    "BQgsqSngDqy2I72sMiIIKnxkI/xGdlBFihBUEPxNNnMP4r3slnkoYeYulgmk" +
                                                    "3QKonH65Qwofjh/IS1rLY0OAVGSAACmUKuG5TZlUAKRKZVV2BUEqUoytGGbj" +
                                                    "hyaIkHKSIHyhZ86PD1NP4tV/x5omfLocnbsuYQFBTuAlbeXxFaIuxwm6RKnj" +
                                                    "eO4rZVIBupwoq/KqQF1GsRWTHMVF/bqMeuZVN+cXgf9KAPCniMCHxL54q182" +
                                                    "I6HKea2uRYBY7fMB1Z72b1UrkAj7nagOOvpSPF4q2LSHM10QWcLjM12iOZEI" +
                                                    "3LY6k0tfweO1ooVdJGKOTGCTW8Ak2pciEfCAm0InxdZ1/waXiFTbc3VkRg9z" +
                                                    "f2SOM/dHatBItTgo532l5XVaXCKyLACGyyE4wyRDs6itsydKQVvipxTuRB+l" +
                                                    "oH3C7qzM3WfBySaexQNKtvBY/PhMpFnwWShVw3NfJpMK8FnzZFVeHuizmK3a" +
                                                    "HAdV4/dZNVkoBQ6gxbyaq2UDiFOKxJegFBRRqPBOD6WwsAUB5pqXjVJE5kOQ" +
                                                    "ssqI4LPj6OIiiwOwlUFsQdAouAv77Tjo5TkyfyVMg/1lAp7HHrF13blDyn47" +
                                                    "Dko6m8cNIqQuFCBlvx0HuZfLpAIgNVBW5YpASK3DVmxy8LPOD6l1XkrhjFXn" +
                                                    "iQvX0zTwbkCN/Zhxc6zugxeGdB2v/5J9lMV+8RgLEb8BBc9fkXbe8B/w+BZf" +
                                                    "B+SuzVFiKxTTxsX38niPX4nZ4Eg2oVa2");
    public static final String jlc$ClassType$jif$1 = ("iiDBs7hTeHld1mzoA8m1uYMEDvbwlBFKyvC4UwTJdUL/UKqK507LpAJAMllW" +
                                                      "pRkIku3YilscRGz3g8Sb5OhsKVTXyKu5nsfbfDq7I3ed1UOiNTSu4/G1os7u" +
                                                      "FHSGUmfx3NtlUgE6a5BVuTNQZ7uxFfc5Ctrt15md5KKWPge4IMABPig6QLhc" +
                                                      "i7e6sw1WuAm8OvLtLIMJ7n0Hy3gIw2vRPm4e6mvjrIA2PvrfbeMTrjYy9mJb" +
                                                      "DdeVcIxAVwSlDTyeIQClh50vEKnmsfvzHQEdfjrg3q8h2G+SUqpJ4JlznGfh" +
                                                      "O7Ps1AvjCd+creAtarQ65xtPv+1xPEEuRt+ecxB50A/Sg35sM7FDuYlBmHVP" +
                                                      "8kY6af2Txy8cm2VA5HkeP5ObZYK2J/4EwSsmGWyo5hzfhxhyNA4upo/jjXrH" +
                                                      "6p/POG/mZJzD2C7nnWWa4NPyYb9xmNjbuYmhceCbceInNuGZujLfV3vZl2Zj" +
                                                      "9+zq33vorsbfs1eYra/BFvL3ttxfRHJd56fSaquGhi1k0z6+6xI5apI8eG8T" +
                                                      "rj+yP9dRgq9PweeZKtnnmbqZlyiTTvj28TM8IPMMj3/j1nuPE352aOSFvJ9O" +
                                                      "gtexMuyzyM2xt6dMrn3kwIQn+ZfVsr4U6kjcu2vRkg3vTGMfW+pF10Tr10Ol" +
                                                      "vetIAVt5cmbk/gaMWJpVVv6CiZ8W31c43vMNwFLX4Clz47TMIfKbnM8Pub+j" +
                                                      "5/5uc3NsDdl45RObSy/GN90LNWN5OkOhEYfvC1kPikNZl2B9p7G3ofIKacHH" +
                                                      "iR+YcxXrfr8utPqGpXUFX5xjv18ntQ97W+n/AJO22tUlWwAA");
    
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
    public static final long jlc$SourceLastModified$jl = 1501546578199L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM28CcwsW1oY1u++N2/2lQwzBma4Hh6TGffwauuq7mYgoqq7" +
                                                   "q2uvrq6lu4sZP2rf973wILBsg0OEEzLYRDZYikiUkDEoVnAWyxKJshjhWAoh" +
                                                   "TlBkQyKcOCEkdnZZTpzq/v+7vHvvu+ZJwXJLdU71Wb7z7d93Wuf0N3539p6q" +
                                                   "nD3Ms3jw4qx+sx5yp3rzYJSVY29io6qUqeEt66fmwNf/zB/+2F98dfZRffbR" +
                                                   "IJVrow6sTZbWTl/rsw8lTmI6ZYXbtmPrs4+njmPLThkYcTBOA7NUn32iCrzU" +
                                                   "qJvSqY5OlcXtdeAnqiZ3ytuajxq52YesLK3qsrHqrKzq2ce40GgNoKmDGOCC" +
                                                   "qv4yN3vdDZzYrorZD81e4WbvcWPDmwZ+M/eICuAGESCv7dPwDwQTmqVrWM6j" +
                                                   "Ka9FQWrXs29/dsZjit9gpwHT1PcmTu1nj5d6LTWmhtkn7lCKjdQD5LoMUm8a" +
                                                   "+p6smVapZ9/yjkCnQe/LDSsyPOetevbpZ8cd7rqmUe+/seU6pZ598tlhN0h9" +
                                                   "OfuWZ2T2lLR+V/ien/jBlEof3HC2HSu+4v+eadJnn5l0dFyndFLLuZv4oT/E" +
                                                   "/Wnjm//Kjz2YzabBn3xm8N2Yf/uP/L3v+9Jnf/mv3o351heMEc3Qseq3rJ8z" +
                                                   "P/Kffdvmi+tXr2i8L8+q4KoKb6P8JtXDfc+X+3zSxW9+DPHa+eajzl8+/seX" +
                                                   "H/5553cezD5Az163srhJJq36uJUleRA75d5JndKoHZuevd9J7c2tn569d3rn" +
                                                   "gtS5axVdt3JqevZafGt6Pbt9n1jkTiCuLHpteg9SN3v0nhu1f3vv89ls9t7p" +
                                                   "mX1met43Pb90X//5evYD2+/+ilo5JTlBqb6yzawmcdK6+oqaBl+pfacKqq9Y" +
                                                   "RuW8VdWNHUwjJv2+5/rt9a0wcL9Sldbty1c2jzvloaqd5M2pN//HsEZ/pfPD" +
                                                   "3SuvTCL4tmfdQTzZDpXFtlO+ZX29IXZ/7xfe+tUHjw3inkOTrl6hv/ks9Nkr" +
                                                   "r9yg/lNXo7kT6iSSaDL1yZo/9EX5q8wP/NjnXp20Ke9emxh6HfrGs7r9xCPQ" +
                                                   "05sxwX7L+uiP/p3/8xf/9NeyJ1pez954zvien3k1ns89S2GZWY49Oacn4P/Q" +
                                                   "Q+OX3vorX3vjwVUT3j9RVhuT1kwG/tln13ibEX35kUO6cuUBN/ugm5WJEV+7" +
                                                   "HnmRD9R+mXVPWm6s/+Dt/SP/cPq8Mj3/7/W56tu14VpPXmdzr+sPHyt7PcvE" +
                                                   "//ZP/OR3/34rx3dDMPQlGPwueJHf6clVnM+w8OZtv1fOf+a/+uv/A/LgSvoj" +
                                                   "x/zRpzy47NRffsoZXIF96Gb2H3+iHUrpONO4v/nTh3/xp373R7//phrTiO94" +
                                                   "0YJvXMsrY4yJIVn5x/9q8Ru/+bd+7tcfPFGnevZ63phxYN0w/7YJ0OefLDX5" +
                                                   "iXjyVRMm1RtqmmR24AaGGTtX1fwHH/1O6Jf+p5/42J1+xVPLnbTK2Zf+0QCe" +
                                                   "tP8BYvbDv/qH/6/P3sC8Yl3j1BN2PBl25/y+6QlkvCyN4YpH/yO/9pl/6T8x" +
                                                   "fmZyo5PrqoLRuXmjV+6t5YrUJybtmMT05jUiTbocpFaQG/GN4C/dBvzTt3J+" +
                                                   "VaTbtNmtD7wW39rf+j55a/9A9XyMIK/B9old6MA3/ty3bP6Z37nR88QurjC+" +
                                                   "pX/ed2jGUyYL/3zyfzz43Ov/0YPZe/XZx25x3khrzYibq8D1KVJXm/tGbvbh" +
                                                   "t/W/PerehZgvP7b7b3vWJp9a9lmLfOKzpvfr6Ov7e582wokRH78yaX738mB3" +
                                                   "X8+vvR/Lr+XH+1dmtxfsNuXbb+XnrsV33snl+vr5O5WrZ+/PSs9Ig8lEH4nr" +
                                                   "IzdXKT5qvjOqawk/RuFDVxS+a3o+OS398/f1n3wBCt/7DijUs/fmZdBOjqJ/" +
                                                   "DPQm/A/eA/ux+/pHngI68dmI48y6pW2VFlTBpM0v0IpJy5LJhNv7zMH5sa//" +
                                                   "s//wzZ/4+oOn0qvveC7DeXrOXYp149AHbmzqp1X+4MtWuc0g//tf/Npf/te+" +
                                                   "9qN36ccn3p4s7NIm+Qt/4//5a2/+9G/9ygvi03vNLIsdI31Hbn/n9HxqYsh/" +
                                                   "fl//ey/gNnvH7Wvxfc+z9Trr372v/+Lb2PqRCTe5MZOgqq6cvU3d3hN+rfb1" +
                                                   "7NUpUX1H3BbT8+nZ7NX339UP/psX4Ca/FLfrrN+6r3/jbbh9sHoKsedTy5sr" +
                                                   "upPz3/3Gb/7Or334M79wi4qvmVNUuVnPszn58yn32zLpm9Tf/xjDb7piuLq6" +
                                                   "n0lrP31Xz/63eqb8/xnX+MlN3SdTvy9w+0em/YGbaR+M/N7a5884a/ha6I9E" +
                                                   "9gMvNt4HN/9RT54rSO89+eRHXo+d1LtLSQ/X4tI/XuHB3bRHSNwFkls82MRZ" +
                                                   "6lxj0qO+u0QsyN58vEWbOvvncC1n3/6MHvA3ET5x5/86/41f2X/e+skHs1cf" +
                                                   "e+Ln9lRvn/Tlt/vfD5TOtCVMlbd54T9wx6AbgdfiD74khGUv6SuuRTLx0Lpy" +
                                                   "4BH1H3vCmbso0r+jyYHT862TybX39fEFJte81OSus6T7mnm7yT3lZZ+gNsXw" +
                                                   "myOjjMrnjfwpzO48xSuTU38P8ubiTeT6/Y+8WHdevded16vbLv36zXqkQZ8K" +
                                                   "Y+uNR4mkNmnotP4b07Iv4M7dzvYFKEya8ZEnw7hs2v7++G//83/tT33Hb04+" +
                                                   "l5m9p73G68k5PwVLaK6/D/yJb/zUZz749d/68Vt2NqnYV//s53/kU1eof+xa" +
                                                   "/NC0d75iJ2dNaTmcUdX8LZ1y7McIPuMvX5vk+iIE64czalHR+KMPr1kbxFd7" +
                                                   "O3EQCWQ2R2LT0Jp52my8YGNsgj3rnQlaMmiC3uzzXbdKG/nMeBXsjCjc0TQL" +
                                                   "GaRAsqREQaq2L+sdu67NdcZBWBFfCrjWvPbo1ou5A5GnqC0pA4DS+dwUTQut" +
                                                   "Boczz8B4YCJUhJ15cx5dcT1f8chBbJyKxk6naDBC7ZQ0cSNj8T4/cbWgY8wJ" +
                                                   "zlbnbF2dFqhyKkT3PJrl/HBO0Rrj1HFIQL8dTz6/j4ryFFlsfBn1srAgC4UY" +
                                                   "uclPLASxmmWqu1iDkoQ8QehuzitQnuxjUkbzPQNE+419Ou4yOGF3saKCHXQI" +
                                                   "57WN+pFCwqxWyyeQB4vabio5iPPc4NkEYrQzKkhbWjzF9DzXgv1ahZO1vGhK" +
                                                   "Qxf5suAFdBkpkwCNgi3T9bz0NERDkkiuF2kKnESn0wVjSeliUcdrRLKSA10c" +
                                                   "gd08aZljzff2MRDOpZyLUE6n4BKiFyfhhPCB5WoOwesRqWgOLRpQLu/qHJ3Q" +
                                                   "EYRcUCQ4Z9lETco+5DSQEOyIo9SBPWY7jBTZ5V5c79VisI784QRBzHKtqb3Q" +
                                                   "Y5DTQpki67kfBSx/gkoEjXYopKqKVhi6Get+EThyDepMD9Kqd3GdftFUIN6r" +
                                                   "NUZu8tYZilVOs4q8iUeKZhg7PkGnTVKfJHO0c25EA28hkvoGA/fSEPSCWphw" +
                                                   "Msh8SLoHsyat/hTQ0XbH0AfSJD25tpmuU7Nm3vc6nxxKv5E3OhGaFGmHm5MP" +
                                                   "mEOucp5Xq1Cr1UzBF+rQLbsYElHV30Irh8mOCRX0kT5trNvDxoZl5wQAHT6M" +
                                                   "wiZK7HyAM0ifwC0TL3dTPRotJd9JOoHYW3zOYA4NhOVcR4qlL9mn3aHaNWSS" +
                                                   "n88juqrnjoOSzvqEdMUxoyeZYZeYJ1bno8eETmTTstHmvGAkyeXiVQytFXyM" +
                                                   "bde9I+NpPi2saXFZgLWtSeNFjbgFycyVcp4HeZGrJzzwyqzW9QoykDLes/Bi" +
                                                   "0pfAJ2TpADDsoXQTYNkugF3NxLHmrEz2GAnCiDnxflOXay1IJEzdOnstVOM6" +
                                                   "r4tmrxcDz15Mw2QCvdnpo7o7jqUjxHwPS+wCArfUvCo5shWKblS4UxjVqAAo" +
                                                   "gApKyJojI3MT75SQkGyJZsVU0jAvLBi0DuFR6NHlelQAtukO8mbhB/4pc49s" +
                                                   "dZbkTbLPPXgr8awgR9jge2iFteZC2a9QtxbLoTru2bxWjAObS8O2PC2gvqTw" +
                                                   "ebdjID/kua7RklzT6gOl7EKFyiBVtnOILWo50H2odnlIERgs6vawmnKamKdR" +
                                                   "E9o5gcE0oW33Os+v3XiP+mJ+ErKc4I97VfTPAS5IUDXOk24NOCIghmY2kjtI" +
                                                   "Xri85EbRZbIskscUKCGK9FDzOZDJUygF0MUF1C46QyGSWSdgvCRiLDuz45Zf" +
                                                   "syVnrBjXiclm7RT52KiEMAw1yUR14UK1umAXBX8pO1tigVPfe9w6hEZqAbb+" +
                                                   "ssJVn+YvabWtpACQ2NW6kgVohTEJkPp0crEcYo3YQoDDxcmBhn1MXFxEOuB9" +
                                                   "p3LqvGQrBBnaMwTNF4uqjVY+sRV4FT1dpNNOsI86uE+ORZvKOAq2rWsWlDWn" +
                                                   "KDvQbX7J1xsZPHGuLateejT7MUHC1VazUuMEKulBl3JU9MJsBUOYnymUOUVk" +
                                                   "SFOhTGab7aoCliEzB5bz9UX2M36nnEhD0XnFGZa4fFzBMTSCRdeIccL32dHn" +
                                                   "nWwppvuRjzoUlHNMUYK2zCYLI4F1A+HQgQ1tJQXHdcbua229h3a2REiGaIcH" +
                                                   "2PX3e83ar1iC3GEpfzJrLjuOxZbsVAH1Vjp9PAvVwNVhAXGjAa0pp3eIBCMs" +
                                                   "+VIfyVCRhbleLLmqW+23jVnyQwgw8bkJLT/Yjdq+25Yj0AL7cIU44WWFbKw1" +
                                                   "nZTHYKhzufdUde3qe88upKNWT6q5UEHUL6I2a4pxowmGfMwYsdp18RK3zNWy" +
                                                   "VArNbxpUBhMvhfhiYXqbHLn02GJPCZUtNggznnoI7Dmr007SSCT7JYs3B14G" +
                                                   "NaU6hRsrWKc4PfRbtjaOaCxCFtwnne2uoW2+XZrC5XzoDXa+4wCHj+CqMdAl" +
                                                   "1q1XHobvPNRg4biI2LVL8uk0z0acdblZLNeOAFS7fVGCMAtsSbJQ17w8TMu4" +
                                                   "kabyKzCe9DHZQabmGFtCXs/h+IQgaRtBbqkH+9MZv+DefOsV9ZLg7OP25IgW" +
                                                   "24ywNgAnFTGUBMa17TZaGHN7g57WfbHzjlZjuk0zZTfpYM/dTQ3DC5MQ8d2+" +
                                                   "jnCP3GyssS64tmJCmrJC5HwxxDbQ0G4Ncq5HGRhG42i6KzfJlpqyHiHptvXQ" +
                                                   "qye+Lv1TQECCn4Lwib7M+0y3kTDsL5WzzmOTkzzNIo2RD6uNs7P6juAMngp1" +
                                                   "t7AKtEmQhpKxqu85bN4A7ajPMZDgeeA0RMeW6DTGHt3JiYV6xUJAsw9yzdI3" +
                                                   "UH2aXDTm9Dqb5GV5lEY3KPto7+AG4cq9FFKXqbNnAQ7N+6FK460QN/Dl7Lbz" +
                                                   "tNbdBj6kIYFZg1ez53lZyCeTZy7q4rDJ51pXXsDKMKIDD0pugCYnvdE9jYUt" +
                                                   "swNO2rAP/Sn1Cfj1pH9zjgIt3CfMA8C3MLDUZCnGczpS66Hdd4Fs8/t9fDza" +
                                                   "4GKL1Ofhoi+I/IQxBk4EihXvdIvyAk3QzrZtH7qkmK99+XC6HCvvYJam0tdn" +
                                                   "drMIhL3W9p3rV2667DAZX4VadDkftQZkGH2PiybGcgIr7pm1cXTz5RLx1POU" +
                                                   "Nqgw3Bc574Nn4cQeeMcvAMmwKgGKVKJeMGv+4ru+owwOyl5g+kKfDYiIONoM" +
                                                   "acVzzKOxHxZRUmoxx3oJoehKt4qWnmUm5ZnhVayJYMaIj2myXqAhA6KnwuIs" +
                                                   "Ap4U9HywtfV6Pu4jraDXxeEkHJIVdKyiUphXBgCvzpd2KKq5ZF9ggYprr9n1" +
                                                   "XhFXeNZ1ru5vHO4IRnYWTTq4Azk4wkJwpQUOj8Htii301R7hSmuIgppGDtQc" +
                                                   "BM70oCwXhkHp50HZEjyxXBKlvaOcY4ZEoR4lBqr4CYT1EmcjYqwgcwPTuREb" +
                                                   "RhR1/C6qOiLiQXRp7IG0DnIV4XsRM7h6iWaiFsJt6YlrPd675W7dDB2NQXAP" +
                                                   "lv4CFdBdq/WTb/YmH+fvSTTqR253WcYuLiKOuDmPPrUmXJAD3TXQKWsV7yIJ" +
                                                   "nJNGB7mxeq51M2fF/GjAyNKv4EnWy+0yPCyT4KyOEIG1F34wXFdkVUN2bCvM" +
                                                   "7fBinPYpdjgWlCJpUEBOYNUN4LqVeo61BvEheCk1wmo/ClNS4RhzcN8RBt4z" +
                                                   "hXeKmRBAS9B0ETPtK6hKghRaphQvwxdsmS77FbQ+n1sAU1Emto2d4MK1ICg0" +
                                                   "V5WbojqvKpgbuxXL2eLmpHpkTU5Z0RRdPVYhi8t6Y0Kg1C+VPXUuM2paLOAX" +
                                                   "o5JMWeHCiQBEPBJlm4nepmtWnZ7kzbJX8u06r3YJa8kucfRGOFn6VngqkA3T" +
                                                   "CeIlnW+xSw1bbcgdmdY1KmtxVmwN3ELykDhsGRaHcugGJF5Vlq3FQ8H4xMQ9" +
                                                   "tQ/9k56Rjc05UAWHeNvGnMZb3GWrS8x5jo51Wg/2UiZoTuTjpbPtBYMd22M7" +
                                                   "mgDBbh0DrVdJxIvV5PqWW8nypZN+NvF+P5BQ048LansO15t2F59X+o4C7bPq" +
                                                   "bWAsjTdajleJA0vd3gIMEsHEfpz8iHj0CZ+nzdYNceM47xredVxCUni7kzAj" +
                                                   "lkae92iJ3yxEdLFZR5BUX7DNSnGEgPJle+g7utuOUh0fpEXYr47VmcA7nGEt" +
                                                   "s9lTqMYQJ8LP2JHtO7aviLVp2XgPUAuAbC/URd4HjAqetzkmLU544cFBFPFn" +
                                                   "H0DP3oLEvW20LewjBqA8SVADfyF4uy+sdWRLlbff8MpcwCmvtgdiRV5kZsRl" +
                                                   "oFB70CZ3h/6I4yQbOiJ6QBmGuBBeO+GgdAyx2hbwIkCoRQEsJQePcivu9LHc" +
                                                   "CZLS2OWOAapYGVK9alszU/kCTCKPOMMHz0hEJq2mFK/g1RgYTXuJwFADYFP+" +
                                                   "RwmL5XAKPN/TCq7f8hnQ7xV0LtHz9eG8WUh9PKW5eETiYxI4Kxe0oinNYlr8" +
                                                   "QCH0fCRAtCHoDB2m6DcXgKAK0eMOF+UM8Rp7fpIl1dNRuRpSaxudefXk71hx" +
                                                   "xFEsckX1aA8t6ywgamXmTWUt9THUxgE2dL9nZKHewbBaCFDCyAuoYb1svWb9" +
                                                   "gZHmeqUhkbA0MzEWSIzfo9sjIxwqhstNcr5X3VMvLFbxkQWAQw4MmSOgRbRS" +
                                                   "ACZzGi1myqQHESC9cEdxp576lVAvdsUqMOztIarAvtP5drmP1zqnKwOdLzOA" +
                                                   "lVam0QnSojNrYxHR2tZGV0gg1IUDG5eF27ZOiSfcvN7Tfhrrho7glhygmlqf" +
                                                   "PRzX6p3AQefOag7AiaOLxAqZ7eCSGw1kFNTtTN5SkwDOoVN4VoFdAwmrKUyc" +
                                                   "Op+ulE3fuCaJ1MXo9REynvC9tpZOCx8o+1rLM0MgjO2F42gbP0pQm4VbiUrH" +
                                                   "GPctP1GoimN5BZboTeVbORNMaQzhbqgRx/aL485phxSLSRy00fnmcFyyMpAt" +
                                                   "w27FHQJNpV1PTSANX5YAm1PdPLcvJypgy1UAuyuco/LFsctHAcym7FVKhNWh" +
                                                   "0hisWcLLuI/8+TnC6kDugXO+6ylzfjKWeixboWihu8g/82tV7KKi2O00VMg4" +
                                                   "qTFHylHbTJuSqC68LExyjJj1MUpWKbyp2WorRPmYTqlMirFVe5j8RdWIbhMe" +
                                                   "22O5OIZDKZBQTtklk5OXS7G+0MogxCdHhjWf1vZzQS2to6AxhULysnpqzodt" +
                                                   "dpqHIFwEpxDDXRFebsHQamBT6dxsdBqYQ/r2IChrDxtbV5CzQVaaJloiVXAw" +
                                                   "3EbUOG1uNqA4wgrs6DUyOsuEQEJEAo7kbjeS7RHJaXtYhbnM9LBZuuMIAn7q" +
                                                   "IoBaLBtkUW62Ir2oeyx1YAfElqWpB6go2idgPerrSU0WyupEFaC0N3d90+uu" +
                                                   "YCs6iNGm1CgBB1PYZMR9UKtLG0S5EwtxrVul6GUULsJGH1PVkZhge15z2/64" +
                                                   "DTqugVSyY1JNqi6yo1EVrAeFtslUeqWfSYDwljspsCFDWHYRgoEUl4gcU4Ph" +
                                                   "Aek41hmAHq8LCNgQzXLKUn2OaGnaqrhim8EBRc23K5jMaGO32KDuWHbJaYVZ" +
                                                   "49Y/5XRLDeuxCbmGRKttvN0Fdu8IJJdEmGMGsCgd5VOyRS96KNntYeHkonWu" +
                                                   "T42N+Vqx1haQlq1b48JSZGGFwX4l772agcjAE6xFCdBofBBFbkC4UOrts6Xy" +
                                                   "iI2FmRYnm6k/TQcNWSbtqiV5Lr9A4bjKNXxDBAmtB91e8wS747tpJ3Xh/Iuw" +
                                                   "vGwONGmLu815tVk3B9JadkA3JzHJVNUpAseryxk8tQkOrE7bdtkVFFk5cK83" +
                                                   "m4NtaULF0+fLYFOSRpCdHBLKgpjP4UWN");
    public static final String jlc$ClassType$jl$1 = ("K2rtiov+AtnmAY4bl2fO2w2/kE/QSgkTbvKByIbrNudGx8005IsIP/h7TbPT" +
                                                     "YoeYY2A1HWlbC4lL+bCH2igRRpggN/1lXy/nZr8eJBhBE5u+7rB0UxKG/WLD" +
                                                     "1ANvnk1oTgYqpJsL3fQsAVtrSt+s6rTo6772FVDvp1052pJoVkDN7jRMOcbk" +
                                                     "/XN1KCTCjK2kaDdbSQttn10u2714SVoMaqx0B8y3oI635mK3FEhnaZdSeTQ9" +
                                                     "BEARWl5yBzc3PCThKNEp+0RbXsgDcjgBC5SrmznD2eAchvkVxMTQGmMTZZdk" +
                                                     "5xyAqwJnqgzj1XRHigzls9CmcftzDOycHpc9Nt32W5RfTDu6c+uNItSATc7T" +
                                                     "mI2zroDiGL1aNk4fJA7lLylZdCJYicp2ybmABros6gM4peedQoupT40HaHXW" +
                                                     "TLKbNJBRqrxWfLMCG7IUHHa0RyEZdA9FhDUfkeBmTZ0zDDKWvY8k+JxjUgxj" +
                                                     "2MYDz6C9UyN8s+jOBp3lsXqCCqZYeUJWOYhEHlSHPOag2aoG32DFDlSYkss9" +
                                                     "mzJ229Hd2SUV4uJ520n5fuRWIUuNtOQ5Ry0EKIFCYdI203beT8l/lBTyXKgS" +
                                                     "WPVLDGHOKFTxKWUy3mgBk/WhKV6G4XLYLJDhuEbsgqxpfvACHxUzA/EyoVKF" +
                                                     "s2tCSww8tsjJAhehqzaoQjEbkA5SFTlC3gJydBkdFCBaBmYqifRqW7rHA7Hw" +
                                                     "myo+E4rDqKmALvPdwOpz0+ZM20g0LW6bHXKW6SkKtGG0XkHiKkllpY/0CyaH" +
                                                     "uDJ6TDw3HRc4wFNWjLbdQutXBz73EiUIK1mxnXnrrIwhSnkxjLAkbO3Yq0bG" +
                                                     "YtDVcYu2tOcg2mrRVADrX8hGW5ndPDkQTr48pXSKY1CPSvkSdhfgAFssyuot" +
                                                     "ud82h16i7LAyUqqiIk6BMakE9tMW31vJO/nYUAmn1upqDW/0yQ+welUUFFHQ" +
                                                     "dD2stkpj1gMFoAWsoAxaIYCN0kGQCUgWFufSGxteamlxL63EsHe3orpO13Lp" +
                                                     "Hea+Sqf+IeHPzYFKTCKEVaU4bZOLwhJrUBr9RT0KS3F97FaxaynhulNHH6xI" +
                                                     "fl0v18x2iaOxOrGKGowSpDoYHYnJV2Lgxawblcn8xM4ZHAS13aoceg218Qvv" +
                                                     "qWHJzg/8EsFc+rIOTD+S6CHR3Z2sYi0e78+LehHJ8XnyitAEfI8dyPika3uP" +
                                                     "S8mWb8ZKuZhrBxXEXSYLcevIuDtncHHj0h7t7trWLx2mOkastoLKsbLNUBfO" +
                                                     "c4bdGiAwrw3v1ATDqj7isWiZILBw9y6hN1hjLLdQA51xdRspYzfXiwWnL9NM" +
                                                     "K2JwIeOOD0qc32MDYZgsQZc2HujTzp+tKghiel8sVitlUynUYYUPJnzR0nWF" +
                                                     "qx3C27kfNEen5bv1bgEMVb1d0s5RTPb4oYOkmKgjnzmeUURv9lKqL1hwc0Yx" +
                                                     "bLcEQfVg7J2RmpvxstB431JKqldxZ907a2hTEjJGqQKDLY+bi7ZgNTGGNH3f" +
                                                     "BHHCUNPG1lYxwJbTQpFO64XPo/WZhzpYJ/xxg9irjaPvs4vEHiEgwnt1R3h0" +
                                                     "uZ+SwbSLiRzS9g17UKyk9Blp72ERI0kOUcXLaErgWczeIM4K7ajQ69wS3wg7" +
                                                     "vikb5bR16kQS0bJz9EPfslLrHIY8mLR6k/ibwtxNOmtNfhkHNSsoANLykmC5" +
                                                     "05IezijRp0DwrOft6FK6sd9v0vKC2TQZmPqUboGbq5xQQ/dctWqgi5FTgsFc" +
                                                     "nVCOT1G7FyoyOFh9RlO0EGJrMJAu4Pxi4M5obyoBjPoTXCQuTIhUVfhxAXBw" +
                                                     "s/AOps9nlOnuA4A5OyAMzgMJTN1pJ4QcTcWdkgLbjSXLqldN1OX4lBZVQw0T" +
                                                     "BrfSTsBuS6wLZF5TjXIuzWKuTGCxgfVTqpfWNjP4a5atsmqNcuqc8IuNt+r3" +
                                                     "LJD25jztMQjZJ7VX8Qe4gaPNiVN8QyHD2t82l5TYjuHCQx2+Gn2e3YMTj3lL" +
                                                     "p4EUTC/JTsAOG1OtcGNeeyABgJOgl/uUErbtCqpLf6XCAy4hc3VzipD+4mAr" +
                                                     "C852u2hwDvASFwwlJntGOXHyGhAXWE2OnJdhqax3PNR48ppTrT1RiN46ThTP" +
                                                     "6zlKnnZuoq90sLFppMXlfJ52EDuh7JizlHLIPEbPZ4M8nAWcdpda58+nfXZR" +
                                                     "sIBIBWkhHWPycPR3qrTqBaAWl8nyhKTV5kwN535Z7Y6065LroWpda9ec5kd5" +
                                                     "2gfAejKwCTBuzNbmtgdZXy2ygyO5DbOY4tiZpBXxoC0FSkiky/ECdh7Rhccz" +
                                                     "eDwtLqamqnN1t88JyasKOfW2xQDTS7jiA5pm0z6ip02gHRNk4BPqtB8VhJQ/" +
                                                     "LEqkitMouziXJvaSCJHYLKUwVOoyN/QBWoZK7gKKuLaXcXyTqGyzRxU9VnH2" +
                                                     "yOqaBk+QCjUb6v3eDP3BoCOKlWlq8PUVdthCwmFRa0CPZonLZVZqVs1FIgml" +
                                                     "wWPTOfekQTd9l2BHNp22xYtS12iiybusANhCIqF9dTwpFK+RgFnwTqNrwtw6" +
                                                     "e+6axQ+bNOA3VM+hiwJawTRGsY4BN8cLcVm6PAHpS9iE1DLCw2VqeKLY5vKB" +
                                                     "XBQwJ1M8BEoniwt5CA5EfUcj3AWLwNrtHBHKMs1m9qyo7DfKaYVHcG4FO3eD" +
                                                     "JyCd9rYOAZ1xDkjFtBAtOnrr0YVlkQemZKAm6FrxMhSBJ33QjPOGHTh8sx+G" +
                                                     "3aIbjtsKC+pqsFlJa4O8V5ojMY8zCtksi5FHTi4xyIbTSwJbt8QFOPh8Tqbd" +
                                                     "Sfa1DhFcJufZFZmOOqk5VBOMCYsYFG5rC8DWBS3KCAnzenMwCljdBqTI9ozj" +
                                                     "kcTxWBwIcYudusn9EmhenEON2aGRKFVVQS+4Q4iJU1TsxC5WyUqy8azB2+VS" +
                                                     "CTNUiQZ30HgPgGI8X1JUSUKIGW+HdLHcRhmWrCyBLqSG3BBx24NUo7tcjtOe" +
                                                     "oBEn9JLjMotsJ382TLvOaf0YOkelH5LnNJDaMzgqnRltBED3ewsbG6939jYB" +
                                                     "twDKrGNem6+OHrczVwRhrd3obDorYsrbCd0l5nIzamTA9orSV2dklQaH82IK" +
                                                     "EzsPzjTjdhTgn7s/VfDx25mHx0f7w8C9dvzRFx0cePV7gmBLVEtfcajYhpIx" +
                                                     "w1cJ1Fz43bY1pxBAskO7WaidwtgqB6hswaLgciKWwfk4PuXHiI4a5BLElXXc" +
                                                     "j8iUmpio6FesppwHtkHTyjXdbbGkEceGVDEQFLlZAHsoq5YNScl7NXF7RKin" +
                                                     "wL7DDJTQGkWQ9GXTk66FbuqyhqbNAMqyp4PnLGgeJw6Bh02h1wqWDlZ10KnB" +
                                                     "k5XYcjVH88wyBakB8egObo+HZOFgSRuWNA4f2tI1HV4pw8uwThhzazuaRfe4" +
                                                     "1snxVhkcWtrEPgq2OzZNKrcdKWlnu2HpIcXKh/dzWS1yZsHEY7p3fXF5qCC8" +
                                                     "DTf23CodvDZKCUP7+tDOof6w2zXHeu5YPYGCOCB7CFrxS3Jy5jGRUNphFV0w" +
                                                     "w4WVSS2sBNZwlIqcAyqa+oWFGWCx6+Qq2Z+GDPVH1+/9QcAXTZ4BYXguKSwH" +
                                                     "DuIeSHRm3MKbZZqeTsZCOAxT7tMnQmg2l8S3nI1pOXR6/fl22qG6GtLqMayH" +
                                                     "6/lYIEiblZXpVpBzKQ2AIFsOqevePVKMjWKubBTN3g+gCByxOdbTqJHTK2e/" +
                                                     "mng2Hw5r++gV60PnODpbp2liFno8BIrShvBK4Vf0gedDBAihtDnsEBQ2RJls" +
                                                     "mbXo1U7PN8M48HBfYzZfpkjU0VI6112tKhcqFl1/nmiPkYe0yp53T/OchECl" +
                                                     "hEBxyuNqGtdq1ErMCPAM/sTkmtZim0BfnRDIWiAtL3Qkd15s4nGxVHjaZc2U" +
                                                     "Xx0acx6iANpYiFBt7XiBHkVTHoC9sAY54SSgYiT6u4vbbqDoEETCxB9inS/3" +
                                                     "SObSrGFRVHCcX6z+XLrlqqkPxT4/q+QZ7cMWWqW1tF6e5imAMyIM12p86nD8" +
                                                     "akZ/6t7ovuk5o3sDegezuztI9ZMvOQiHv+0M07degd0O4j17Vv0t8Trku25L" +
                                                     "9E8OZn3H44NZt8/r91c3fva+/umnDmY9dRZ6dj2Q+pl3umVzO4z6c3/06z9r" +
                                                     "i/8K9OD+xBlVz95fZ/l3xU7rxE+B+tDtPXqMxgcf3SSZnlf/zH39x58+XfaE" +
                                                     "S89QcMPsA/dT/th9/UPPUvDiA3H/8kv6fu5a/Ew9++YrY994lrFvPMEnevsZ" +
                                                     "uS9Nzxdns/e8fle/9t+9hIoXHJC7Tvnb9/XfemcqXnlyqPqrN6j/xktI+QvX" +
                                                     "4l+tZx9qcq80bOd2FPM29UVieDg920kR/v59/bffnRiuU377vn43BPxbLyHg" +
                                                     "L12LX6xnH/ON1I6dp04Nv+gQXJsF9osIA6bnq5OU/tJ9/ZPvjrDrlH/hvv7x" +
                                                     "35t+/fJL+v6Da/GX69lHPKd+hqDLi7C/HsV2ZrMP/8n7Ont32F+npPe1/y7E" +
                                                     "8isvIeFXr8V/OInlSoJzw//uXOO1/fAi47ie3k9ms4/k97X47ozjOkW4r/fv" +
                                                     "gohfewkRv34t/tN69qnrcd3JlwXu8I+k5SaQz03PT8xmn5Dv6+95dwK5Tvny" +
                                                     "fY3+3tTpv35J39+8Fn+jnn1iMu3rDSv8yWnaa8+/804q9Wdns2/6X+7r/+Ld" +
                                                     "UXCd8uv39V//vVHw2y/puznK36xnn6ycGn/uxsWLiLjdP/z8VdSzu8+trme/" +
                                                     "8fzFsIdf+Md8L+yL3/2waIwqKJqsdr5wd+Hq4dUzPbwG6yBts8jZOu5T1/G+" +
                                                     "8MWHP1j7QfXmiwPOF7745a99Mc/fWS63z+vPcuPa+z/m+Uv4/j+/pO/vXou/" +
                                                     "U88+/U5Iv0gs1xTidl/oGbH8m//kieXuNtDTcgnqqxwefv9X5YcvYvf3vZ3d" +
                                                     "730Ru//3l7L7/35J39+/Fv9rPXvfI1xexN7b4p95jr2v/Pv/xLH37rj9w3vl" +
                                                     "v79rdOPzo9sPmfuF779d6Li2/qCRmF+7HY+/e3t8b+/29TZP/NLD++FGazw7" +
                                                     "/u72wt3g7KvkJMbAffiF7GHweLGHz2J/FfWzbQ+th9/78AvPjcy+/PDubsbD" +
                                                     "5y8WqtcrCk7RTNoUT6xVsi9Yb74kJ//SjZTJnu8BukZcOc9Z94tvwFyLH76/" +
                                                     "ufl2RXrwZNQt4a+uo1558M7q9spr18Z/MKUgbxfJtZV8WukeXbn99CNle9Rw" +
                                                     "7f3M7wfWH3wJ1h++Fq/Xs8/eOGxU9YvZfMOpn5KTZzuu10o//dz/O9z9C4H1" +
                                                     "Cz/70fd96mfV//LuOtejfwp4nZu9z23i+OmLkk+9v56XjhvcyHv97trkjSWv" +
                                                     "fHxKRq+4Xd8/kd9R9/8BFd4TuGFCAAA=");
}
