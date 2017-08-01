package conf;

import jif.util.ArrayMap;
import java.io.PrintStream;

/**
 * A system to handle the submission, approval and session allocation of papers to a conference
 */
public class ConferenceSystem {
    public Organiser organiser;
    private boolean allocationsVisible;
    private int numSubmissions;
    private Paper[] submissions;
    private ArrayMap allocations;
    
    public ConferenceSystem conf$ConferenceSystem$() { this.jif$init();
                                                       { this.organiser = new Organiser(
                                                                            ).conf$Organiser$(
                                                                                "TheOrganiser");
                                                         this.submissions = (new Paper[5]);
                                                         this.numSubmissions = 0;
                                                         this.allocations = new ArrayMap(
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
                                                                              jif$util$ArrayMap$(
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
    
    public int getSessionNumber(final Paper paper) { if (paper == null) return -1;
                                                     String title = paper.getTitle(
                                                                            );
                                                     if (title == null) return -1;
                                                     if (this.allocationsVisible) {
                                                         return this.declassifySessionNumber(
                                                                       title); }
                                                     else { return -1; } }
    
    private int declassifySessionNumber(final String title) { jif.lang.JifString titleObj =
                                                                new jif.lang.JifString(
                                                                jif.lang.LabelUtil.
                                                                  singleton().toLabel(
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  readerPolicy(
                                                                                    this.
                                                                                      jif$conf_ConferenceSystem_O,
                                                                                    jif.lang.PrincipalUtil.
                                                                                      bottomPrincipal(
                                                                                        )),
                                                                                jif.lang.LabelUtil.
                                                                                  singleton(
                                                                                    ).
                                                                                  topInteg(
                                                                                    ))).
                                                                jif$lang$JifString$(
                                                                  title);
                                                              jif.lang.JifObject sNoObj;
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
                                                                                 titleObj);
                                                              }
                                                              catch (final NullPointerException e) {
                                                                  return -2; }
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
                                                                  return -3; }
                                                              int r;
                                                              try { r = sNo.intValue(
                                                                              );
                                                              }
                                                              catch (final NullPointerException ex) {
                                                                  return -4; }
                                                              int result = r;
                                                              return result; }
    
    public void performAllocations() { try { for (int i = 0; i < this.numSubmissions;
                                                  ++i) { this.allocations.put(new jif.lang.JifString(
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
                                                                                          bottomPrincipal(
                                                                                            )),
                                                                                    jif.lang.LabelUtil.
                                                                                      singleton(
                                                                                        ).
                                                                                      topInteg(
                                                                                        ))).
                                                                                jif$lang$JifString$(
                                                                                  this.
                                                                                    submissions[i].
                                                                                    getTitle(
                                                                                      )),
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
    public static final long jlc$SourceLastModified$jif = 1501569085951L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAL1cDXwVxbWfey8khG/CVwIhXCB8S8KXUggomJASGyAlgIho" +
                                                    "3Ny7SRZu7t7s7g1BHyp+odWiPxS1z0LbV6wfpaCttn0VUfEDtK3W1lbaPsVn" +
                                                    "f++VVrHiA6vvVX1zzsx+zc7dXGzfy++Xmb2zc87MnPOfc87M7O6+k6S3aZAx" +
                                                    "G7XWSmtLRjUrL9JaGxXDVJONemrLalrUnPj4Wz9L3ntJ5niUFKwnfTRzTdpU" +
                                                    "WtUGUqRkrXbd0KwtFhncsFHpUqqylpaqatBMq7qB9EvoadMyFC1tmZ3kahJp" +
                                                    "IIM1WqKkLU2x1GSdoXdYZFxDhjbUltKtKrXbqsoohtJRhV2paqxJKaZJORVg" +
                                                    "qc2kT8bQu7SkalhkbAPtOK+dUlrUVFUjv9cAv6q7DRK32fPxscEhZza6XdOr" +
                                                    "7rrn8sHfj5FB68kgLd1kKZaWqNHTFu3PetK/Q+1oUQ1zSTKpJteTIWlVTTap" +
                                                    "hqaktCtpRT29nhSbWltasbKGaq5STT3VBRWLzWyGdhHatAsbSH8mkmzC0g17" +
                                                    "OAWtmppK2r96t6aUNtMiI1yxsOHVQTmVRV8qTtVoVRKqTdJrk5ZOgiwECmeM" +
                                                    "FV+iFShpYYdK9eU01Sut0AJSzDSXUtJtVU2WoaXbaNXeetYCAY/KybQaFKEk" +
                                                    "NiltarNFSsR6jewWrVWEggASiwwXqyEnqqVRgpY8+jm5YuGOq9LL0lHsc1JN" +
                                                    "pKD/fShRuUC0Sm1VDTWdUBlh/2kNdysjnrw5SgitPFyozOr86J9OLT6n/Omj" +
                                                    "rM5oSZ2VLRvVhNWc2Nsy8NWymqnzYwyCuqmB8n0jR/A38jvV3Rk6sUY4HOFm" +
                                                    "pX3z6VUvXHLtw+o7UdK3nhQk9FS2g+JoSELvyGgp1fiimlYNmCL1pEhNJ2vw" +
                                                    "fj0ppNcNWlplpStbW03Vqie9UlhUoONvKqJWygJEVEivtXSrbl9nFKsdr7sz" +
                                                    "hJBC+k/G0P8i+v8rnj9pkStqF2xYY6pGHeVibqjVE9kOlU7gDWvS2garXTU1" +
                                                    "c0NCMdVm08omNVqDIppLHS+b6YTcYBoJ/LGhxrnZtMW01I5Kejfz/9BGN4xz" +
                                                    "8OZIhKqgTDQAKTp3lukpaiSaE3dlL1x6an/zT6POhOASolgF7pUidxKJINdh" +
                                                    "MGmYUqlKNtHJTY1e/6lNl110xc3jYxRNmc29qECh6nifca1xLUA9GsMEheGv" +
                                                    "LshcsePc0QujpPd6aiTNWrVVyaasxpoL9WyaGpNhTtEqldqZNFo3qYUtzCSQ" +
                                                    "xiIjA7aR2URKZrhMgGw0hX6FOAFl3Ry0/cSHB+7eqrtT0SIVAQsRpIQZPl5U" +
                                                    "g6En1CS1mS77aXHl8eYnt1ZESS9qNujYLDoysELlYhu+mV5tW00YS286vFbd" +
                                                    "6FBScMuWSl+r3dA3uyWIj4F4PYRqqZ89F8oJif2Q53vh7tAMpMMYnkDtwijQ" +
                                                    "Ki9qyuw+9vKf5kRJ1DXggzwOsUm1qj1GA5gNQvMwxEXRakNVab037m28c9fJ" +
                                                    "7ZcihGiNCbIGKyCtocaCukUq5huPdv72+Jt7X4u6sLOoz8y2pLREtzNIKCd9" +
                                                    "+eC+zfPdnkHS1ia5/aFGJ0UNH+2uWbEm3aEntVZNaUmpgPO/DZo46/F3dwxm" +
                                                    "OEjREiZVg5zTMwO3vPRCcu1PL/9rObKJJMDpuTJzqzFLOtTlvMQwlC3Qj+5t" +
                                                    "vxzztSPKbmqTqR00tStVNG0EZUBQaTNx/NMxrRLuzYYkTqezeJM2N9qdtDh5" +
                                                    "aNygsaCiOTHig/FVmbrat1DffcFM0FhJS9AoqCww52qcuzDxwHe32ZXHBCrX" +
                                                    "u7dhyowU+8Db73VZPPlBfPylOE/6JVUzYWgZG1jU0vc1tY5MiopbTeL0pjGG" +
                                                    "pV9ExecETIaSNlPUwTCTsBpvLu3OGOCuuxQD9YRSmdANIHW60QhxWHNi3q3b" +
                                                    "DX3CV86LckEOhGRcN40Ck8xKxTOJeMo2LwsAxsjDbtYVptt0c2L38HsOFn93" +
                                                    "5xLmi8f6KQK1F86sual57qM/R9ADQMpFaa1SFWrjmTibEx/s+Z266tyP32OT" +
                                                    "VN+cFuPHDA19ElpGgRiSX0HoaSAXGMdi2quSACw4+/O++s0DJ99sXIxY9igA" +
                                                    "AoRAjMo17BEdpDV+X+H0p3K1nnG61Jy4fMQvppcdvOQWr5gEAk/tHQ99vfAv" +
                                                    "53z8TRy2A4MJAgwcglAoQDqf9RdthU9B3k569TRy+BuvHe1a9h7rrogDGcUF" +
                                                    "s4cdOlFSehXXLDRYy1uFbJlU2RfTZYir7Hhlw+GnCle95FE2apCKYDNWZPqE" +
                                                    "dImrgBWU8USZPC/ULUvv8Eh10YTfbaz+5NXH7Amw1JHKVP8ABUrvMAumPVG6" +
                                                    "4/fXrrR51LOhrvQM9cusaG6mGy30Gvy10ATLIEQfyxSznXqPY6nX1+96Y1o5" +
                                                    "E7bHu/D7P6m9cdfdP/7RXBag9Ke2bvAFiwlhRg+YX5DBvqxnXcn4uiH8XM6q" +
                                                    "NjMFZRzl+H+yvAQNK6w0y3zBUB0sfdwAIHHlov/c+WknDQBi68nAdsWsT1OH" +
                                                    "CSstuqAD6+n8ssgQz7RCswRhQMob0ojLA6Gx9VX7vj6q5vx3cMa60QZQj+0O" +
                                                    "ho1rFU8gNPvhjjPR8QXPR0khjdcwCqOr2rVKKgs+fD1dpJk1vLCBDPDd9y+4" +
                                                    "2Oqi2ommysRIx9OsGOe44Sq9htpw3VcIbeCfTKf/xYREEzyv94Y2EYIXm5Bk" +
                                                    "PKYTIZmCOovC5VSLtqyllZQQTQzm/JbxfKGHr0WKdKNNSWs0zjd9vgxNuZpk" +
                                                    "C7D7H9y3v7r/Q/fjTC1C/VFtWtxv9QEK+zcb2gD/0OK86XWyobHZ4xCMkhGs" +
                                                    "8hJgluXTDNKLpZPE4TgaCsdyThfzvEkMHLfQ8VdI7TTg1mNWyrSO7N7TLzUi" +
                                                    "JAfgpoetfIuUioB3o2s0Qf5OlfHOrJZ1ygy4V2TotU7HGj7Zs+g3hx533Gup" +
                                                    "EAW4k+G8Fx+OvbJ2w26mQk/Y7vV8sPLxbB3wPYvyXGNiWxY4sHZnYOUwsKl8" +
                                                    "qXqc5695B0YYlm+QYznGsVxg4hYP/NI5oj+jfxH6/yn8QzNQADmdrjV8VR53" +
                                                    "luUZujyMrDSDJobqsoPaqC6+A6HefNdXPqvccVfUs00zIbBT4qXxjHsAJLeA" +
                                                    "rsaFtYIUdX88sPWJB7duZ3a/2L/psDSd7fjebz75WeW9b70oWecWOXi0Fzll" +
                                                    "OVSNTY3/Q+H2+hMX3Y82ejDYOYwSqKGDuYtF9Wl/UT/NdECOQ7sDkp2wOka/" +
                                                    "4lewOJ3WBma07YAg6UKG97qus8vvs4JFwy0yEJf2K23zhOMmnrmvOj2C2U9m" +
                                                    "0P8RtCdHef6AxHx+Qw45uhArpPKlMZcq2M5+nNl3eP4Nn+0sVlIpPYH7i+Za" +
                                                    "zdTsIMzw96yUEz8m65lg/YbKCPYHrN+D+Vu/YVBYwjn9gOcHROu3D+tf5aca" +
                                                    "zms/IqPCqtd4ZrKLkJGyJr8fipCHsBePuXB4KIgQf9FtfOZBdjtVYIuup1Ql" +
                                                    "7YHJgzKYTGRdi57i+TEJTA4ymEDyL0E8ANXrPP+FDw8D6RxuyrZ0aKYJkJBh" +
                                                    "YTgn/HdZ8wIWBskIfh/AwrP5YwFCAVQtcHqL5/8mYuGIgAWkGsJrvyGjCsHC" +
                                                    "UFmTx0Ox8Bz24hVX8c8FsfBcGBZidAXvwcGzMhzMZfMsNpnl0c8kOHg9FAdA" +
                                                    "9SnP/+rDQT8zHAS8zdgoWdsCCMZJCGLDAiB4M38QjIfCSZxTKc+HiyB4WwAB" +
                                                    "Uk3gtUfIqEJAMFHWZEkoCI5jL/7savx4EARukUFGue4Qg3rcfmIO/sickl3b" +
                                                    "7/zrSBr6rCeFPOjH8H+FnsYfkrMND/37+46/88sBY/bjTk6vFsVkMbx4KBQ8" +
                                                    "8/Ed5eB4+vuBMM7WZ04gCMgZywmK80BOqYQg1j+AnDP5IwdD83LOiTcRGyAi" +
                                                    "52MBOUg1mtceKKMKQc4YWZODQ5HzIfSC7xeuZAUB5HzoQY7/WJXab9PyHGyt" +
                                                    "m7L2mRtKzVtZ0DbVQYnabVVi7M9JRbrfHovN7mdV3I7xtgOaPnR1aEJNi8Rz" +
                                                    "H6kiLxZf9nMkgUdBoMYC+n8Fz9dYZM0/8pimUcmoBj//+b9hjMopsmM83Jet" +
                                                    "xJt4XBPQRHNiyPz7WlqvW3wEg+JBKDyMWJuYGCf5ly+cqKLJX89/xizVXXPi" +
                                                    "xIGvHh3357VD8fDQVpP3hGC5kqkWTwRgz4aW9y783TPPjrji1RiJ1pG+KV1J" +
                                                    "1il4uEKKrHZDNdv1VLI7wydWZHMfmkaJHVtv83vLCq5cg+cKiKwfwD3Sny+e" +
                                                    "IiPCFk+Q3AyJjhi6hXqkJfgQAApE5jGdPZkIW7nfCZdjSIQINgXwh5EdTEPu" +
                                                    "BGO9RZsSGZu/TcERj+Sc+vK8QLApkQmCTXGiCqhdKKMK2JRah3iErMmiAPEy" +
                                                    "16ZE4tiL6Y4BoQWiTXGLurv9Wwm5YTmrOrHisD5/KmK7wGrXzIqZeMAigXQ1" +
                                                    "E+1QbKQKUdTLQRAalw943BKZKwdH1AGHg4uClJpus9ji3WA8ZMcqq2nP+LHG" +
                                                    "3R8OW3XdxR+tQbsWTWCcNbaB9GnNplIrnBUrpPMYP4ssRiZxvTVOzUbczKgJ" +
                                                    "TUnF7W3r+HgY9/i4lo6jHbj0qpVv37Rz62WYvf2V+7deelnG2fJ1tkJqlHRa" +
                                                    "twLnDQUJ7fGTVa2f2Nu1i5h+/sKH5gzzNN49g7YIkjm42SI9FVvakbHwHOvK" +
                                                    "H498bOEDe97EzZaAFkQ/shxdv7v/Mu9btRVlhzt3/OMOj+HnaPk58VghmBE7" +
                                                    "89DyfS9+cVJiZ5TEnE3NwJMpfqJq/1ZmX9bqat+GZjkTMwj0fDd0noRYw9/S" +
                                                    "E75Ifci9L0FSRw1UIqWn1Z6VmclkIhFCAryYHWNb9JHGHs0T7ppHmpjhyLVr" +
                                                    "zswDq7qO2YFce/GQrumGjYaSXCCHKq+h6NgkXoB84eAjciGJwF2+nHlTtpyZ" +
                                                    "RXA3MbaL5xmvOeNm4fLQ5QxQ6Txv91BT5+HZ5hCCUgxKYIkao/9TeD7KIvOr" +
                                                    "2vUOtWqjmqzarBubqsCgJekcwouU1jKDBgZ4jX4VY23qRHng8fmJuZphsM1M" +
                                                    "1W09qppVhnSja8ubg+a9ORBpcjI9f7IIuKhIEsksOwbCk1v3yJwOBasOwnQY" +
                                                    "720MQwa04kLIABE+rq1A9PN5DofmERUl0GqHDFtyhAzOUwjOnqtwkPA5tl3X" +
                                                    "OkFG5FocbRkkWUjKhZACI/wJHHjbeb7NC1/s/Q35hxS4QTmec7qJ59d5OQLD" +
                                                    "m4WQwtnWhNrXy6hCQopxsiZvDBB7Q4obsRd3uEi5MQgef5Grc4xgxnBdz+T5" +
                                                    "VInOd+UOEyNbIbkakmuwK9dSvaG5vT6nrmCm41IOhncNz7cEdPXP+esKRzKK" +
                                                    "c7qa51eKutoj6MqJ4KD2VTKqEF2VyprcGqqr+7AX33EVc19QV/d5wj/4PROS" +
                                                    "zZ2O3Y60dXt8otMb/IMoH45JDvL8h57eYM0S95mXMbkewsSN/73X3bUnufL+" +
                                                    "WXYAdIdFFyB6ZkZK7eKRP2NViH2s8TuRc+j/NEJ6T+K5GIaTwaEeBEh6s7zX" +
                                                    "p+IIXPfujVtdTzIHuNRxLot5PsOnFd8mDwtMlxhtPC59cMDzPz1ZUncUN2mi" +
                                                    "CQ2e3Ak885ZUc4Uz2Qz1yt6wKtqlwdVGFso63Vws6+YCbzctcjm026EbmXaN" +
                                                    "P2ADsS973i2uGG24jo5nIA6AG2yTKJ7NtBlKUsXwID6lBbqiJuNKi96lxlu2" +
                                                    "xJ1IYSpzDwtZVgPJY0w5cPl4mLChwk8YOp+A5BDC+ilE59Nnxy949L4mvSmt" +
                                                    "b06z3Y+mfvuy1z8545gNQ35Mhu0dDQn3fgbJDyzS3ysNKHtJFtNJnjDhveCg" +
                                                    "GFb17u6VH739iN2NeWx0GZ8IXxEKqfdD3bixxCFm1n6dv1lbAoVLOTwu4Hm1" +
                                                    "aNaOCWYNqS7ktRfKqAJmzd0pq5U1eX6A2Bu/MP2/5dqwQ0Gz5haJj4U00Jgw" +
                                                    "5a4pVt925PXzvnZiJ65lw5/xEChTe1NHGk5vednWknuWjEahgY/FnnU+o8BD" +
                                                    "2z/K/RyGzc5i16NWPhUcrbLADFcxkZOd9jaIEIN5tm06nS0Y1zlC7EVswc/n" +
                                                    "+RxvZ7Gr7+ePogVQeD7n9AWezxVRdFpAEVJV89rnyqhCULRI1uS8UBSdwl78" +
                                                    "zYXMqSCKTsmc43sBS0STaBStkVQ8cOcZSN5BxaHiUWN459ncdiXaG+0KJD8X" +
                                                    "/I6zrQ4DLZU5PkHNpTKCoaKao33yV7OzrQ6cSnjuO+IBhv0FNTvb6lB7uIwq" +
                                                    "RM1jZE2ODFNztAh7MczRKS0Q1ewWgaSLiOSZXb8sIeAgs3nzTvQRkOWo/GUJ" +
                                                    "TwHgYhg4Tef5ZFGW5YIskaqS154iowqR5UxZk9NCZTkaezHJFdzooCxHe2QJ" +
                                                    "+/wFaL0my5D/4xDkzxCRD4W4QRftk0tLKHNsVogS8RH8OPMzRaN47tv+hdQT" +
                                                    "JbpxrvNgO5D0Ynmfs44S4SAUDRxwmcvzcaKsI084BHNlBJVeAou0fK54rV1J" +
                                                    "J1Oqe9x/djFbdJYTY0Vn9xCzRee5MVt0PmpnAc6L6rPiB1VfQuqaELzAQ7LR" +
                                                    "mRYZLI6vM1cU1sljKNqFYGDlLQwEVnQwOI7l+c9v8GfoaUGPc3heJc7vRmF+" +
                                                    "I9V5vPZMGVXI/P6CrMnZofObKWmdO5nnB+e3ryjyH36IL+bN2Mj1QZzFPNHL" +
                                                    "PkfMQ6GEAkfbEQAVJAkEVi73iw+PRhWbR/QyxwhFzw8BVSuCCpI6vC+cPvXq" +
                                                    "0rVkz94CDA/udIFEHCvklQzKZVP+aMJtm4mc01iejxbRpAtocjZ7oHaZjCoE" +
                                                    "TRWyJstD0YSP40U3u9BJBdGUyuktAoo6N0RRV7uKgqQth3PY1JnLOUDNy2lU" +
                                                    "9Rue+5766uzROQDJozz/roc0pMs3htzbDsm1FhnYplq5H8xyvBq0ekTWcQGI" +
                                                    "o2QEzwSAeGv+QHQeUQZOL/D8sAjE2wUgOs8QQ+1nZVQhQCyXNfl8KBBvw17c" +
                                                    "46LutiAQ/UV/8Qt5lC2rnEJGI7Xbs4/flzroEvuFJQU2yOPwMIXz4lL0Gz1K" +
                                                    "udNe2kW/7fSTFohdF4qWu2QP5kcGP+AACt4+zWHLgNs2nAewrI/uz6fvjCD6" +
                                                    "KBbUsgK8tg+kgkXLXbIfuqrZFtTWNp/ZkE1oMFWthAx4iOe3n92EBpIdPL85" +
                                                    "94SWR3u4PLiAUz/L80dEzHiivfkygie9BJ832gMDoqL1WJGFLw2cZbR30I3O" +
                                                    "ngwbOlQ47In28FHI6PNoTl44K36dTrT3coiB/AUkT9BoTxxfZ4/R3kFZtHcw" +
                                                    "LNp7jpnFY/mbRWcDBPR4mOeHBARGfy+YRWcDBGo/JaMKMYuLZE0+EyD2mkWm" +
                                                    "pD+4syr4vKq/yBPtIcSX8mZelEGcR3sn2DTDNO9o7zD2DJ4x9kZ7HFSQvIfA" +
                                                    "kqoC7hyB5F2bR/REpxNEvBgCqlMIKkhelXnaYXyU98osiuBpB8oIdnoJUDin" +
                                                    "84cUPlQ9lHO6h+d3ipD6SIAUUg3mte+SUYVAqljW5N2hkDoDvYgRFz9ngpA6" +
                                                    "47Xdr/UcPuNDuNN58wdssy7KMlaQvywhFofdDuS0n+cPC7KM9RVkiVSTee3v" +
                                                    "yqhCZDlV1uT3wmQZw82OWLEjOFogytItgtQfPovIfzo38mOlIvLh8r+Q7HQu" +
                                                    "LaHMOyXu13mrxaT4K2b5wFOCdHs4kgOS93n+Jw9pXu4X904W8w5M5HmpKGuP" +
                                                    "+10gIxjrJbCIlpf7tTQrpXrcLzyipFD31Lrl7/DCsTGO14yV9+CFYxNcLxyb" +
                                                    "iEqahNNj8lnx67S9cKwqBDazICmzyMgcw+zsyRnTngSdsbeQugYUqeOM6Zhw" +
                                                    "OPPzn+3gUTG4Aq1W8DwuzvaFwmxHqoW89jgZVchsP1/W5ITQ2c50VetO7YnB" +
                                                    "2T4xhzNGwNfxZqbLAM+ccaw+L2fsSpwjyhX4cBpy4eOG8H5xJfugUwBvkHwZ" +
                                                    "MZfLQcemQILjno/9gmQl3pkWgrfViDdIZgtT3nlHCQzGf8tsjuBUBskITnsJ" +
                                                    "UGAX5w8z5x0l4PQxz8+IMLtUgJnzjhLU/lBGFQKzobImPwqF2TrsRcLF1Log" +
                                                    "zNb5HbQ7f91DdM8DDfCEdo3zsGdzouHMr0d0TdFfYN+qcF7/RCbip3HWwAAU" +
                                                    "DlgbwAsCA5CbO1eIzcDmCk6+lOe1QSHmgiO5AaXSIYIEj1fmcH4ltkcLgMTI" +
                                                    "HyRwVoMHR8BpJM+HiiDpEsaHVFW89jAZ");
    public static final String jlc$ClassType$jif$1 = ("VQhIZsmaHBEKEhN7cbWLCDMIEn+RKzN4W5+s4M3YspsRkNn1+cusHgqXc072" +
                                                      "QCpFmW0XZIZUF/HaVTKqEJk1yJqcFSozBqHbXQHdEJSZU0QDNTSyk2UWcFyI" +
                                                      "BbxbtIBwuRZvXZxrtsJNeCYotinHbIJ7aeSBz4vFDEdB4qYKbB7vonbnXJ77" +
                                                      "9n8hDd9UAZIxPPce2oYM+Fsh974NydctUkxDXgjElriP+3bm2AQWwIovB1bw" +
                                                      "Hs2zBxcA63d6BCvUegA79bCr7geCCHggCBxGdiA/MkhzbnftpR5tB8+ts9MM" +
                                                      "kJg878hPM/8acg+jgccsylO1lgTeNc9TObjum8w7dYc9voByDuWlnKewX4dd" +
                                                      "kT4VlPJTQeUwsiP5kaFy4DtV4mf94BmkksCXQtnXLRP79wzqM3LPmtfZW5r2" +
                                                      "FyiL+Ksp3q+weK4LMobaqqFii5hPxcf5Yy9bpBe8mgbXrzhfJPCEbOyTMN3M" +
                                                      "SpRIvalz6AhPdL7L83e8cu/Rm4ZA45j/cy3wxkmWfYq1OfH+7Fm1h45OOsK/" +
                                                      "5pTzvTeX4sCei1Zcdeo89oGX3nQRciU+TdungRSypRkPO7yfuRC52bwKlk39" +
                                                      "n4GPFE30fXes2DN5Srw4LXEj5xvcT554v93l/VZsc2IT2Xrrc9uLt+HLvEWa" +
                                                      "udrIUmgk4Zsm9oOwwOs69rwfe+Ej9hZlPFn8qJWHrfcVosjGr61sKPxsnfMK" +
                                                      "kVQ/7IWM/wXQcN5vmVcAAA==");
    
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
    public static final long jlc$SourceLastModified$jl = 1501569085951L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM28Cczs2nkYNu/q6Wm1NteyLEvyjfzsSKb0Zjgkh6RUF+aQ" +
                                                   "M8N9J2eGlv3CnRzu25BDR4EboLbhoErgSmmKxm7RKm2dKA5iNC6K1oVboI0N" +
                                                   "B0XqBkmMInVgBK0Dx4VVoElRtHY58/93effed2MBaZEf4Dmcc75z+O3fdy6+" +
                                                   "c7/xe7N3NvXsYVmklzAt2jfaS+k3b8h23fgemdpNo08Db7pfA+Zf/bd/9EO/" +
                                                   "+I7ZB63ZB+Nca+02dskib/2htWbvz/zM8euG8Dzfs2Yfzn3f0/w6ttN4nACL" +
                                                   "3Jp9pInD3G672m9UvynS8xXwI01X+vXtm48G+dn73SJv2rpz26Ju2tmH+JN9" +
                                                   "tuddG6dzPm7aL/Kz14LYT72mmv2p2Sv87J1BaocT4Ef5R1TMbzvOt9fxCfy9" +
                                                   "8YRmHdiu/2jJq0mce+3se55d8Zji17kJYFr6rsxvo+Lxp17N7Wlg9pE7lFI7" +
                                                   "D+daW8d5OIG+s+imr7Szj7/tphPQu0vbTezQf7OdfexZOPluaoJ6z40t1yXt" +
                                                   "7DueBbvtNNSzjz8js6ek9Xviv/qVH8vp/MENZ8930yv+75wWfeqZRaof+LWf" +
                                                   "u/7dwvf/AP/n7Y/+8k89mM0m4O94BvgO5j/7k9/8oc996ld+9Q7mu18AIzkn" +
                                                   "323fdL/ufOB/+AT5WfwdVzTeXRZNfFWFt1B+k6p8P/PFoZx08aOPd7xOvvFo" +
                                                   "8lfU/+7443/Z/90Hs/cys9fcIu2ySas+7BZZGad+vfNzv7Zb32Nm7/Fzj7zN" +
                                                   "M7N3Te98nPt3o1IQNH7LzF5Nb0OvFbffE4uCaYsri16d3uM8KB69l3Yb3d6H" +
                                                   "cjabvWt6Zp+cnvdMz/943/9yO/sT1Be+ZDR+vZ12ab5EFW6X+XnbfMnI4y+1" +
                                                   "kd/EzZdcu/HfbNrOiyeISb/vuX57ffMUB19qavf240vk40nt0rR+9sY0W/7/" +
                                                   "8I3hSue39a+8MongE8+6g3SyHbpIPb9+0/1qt9588xfe/PUHjw3inkOTrl53" +
                                                   "f+PZ3WevvHLb9V+5Gs2dUCeRJJOpT9b8/s9qP8L+iZ/69DsmbSr7VyeGXkFf" +
                                                   "f1a3n3gEZnqzp73fdD/4k7/zT//an/9y8UTL29nrzxnf8yuvxvPpZymsC9f3" +
                                                   "Juf0ZPsfeGj/jTd/+cuvP7hqwnsmylp70prJwD/17DfeYkRffOSQrlx5wM/e" +
                                                   "FxR1ZqfXqUde5L1tVBf9k5Eb6993e//AH05/r0zPH1yfq75dB6795HXIe11/" +
                                                   "+FjZ21km1aGdx5Nm/PZP/Mxv//Rf+sK/SD0RJoqvuvEFcPG55erzEFbeaclV" +
                                                   "mM8w8OZrf1Arf/bv//f/GHpwJfyRW/7gU/5b89svPuUKrpu9/2b0H36iG3rt" +
                                                   "+xPcP/gL8r/1td/7yR++KcYE8b0v+uDr1/bKFntiR1H/G79a/eZv/c9f/zsP" +
                                                   "nihTO3ut7Jw0dm+Yf2La6PuffGryEunkqSZMmteNPCu8OIhtJ/Wvivl/f/D7" +
                                                   "wL/xT77yoTvtSqeRO1nVs8/98zd4Mv5d69mP//qP/rNP3bZ5xb1GqSfseAJ2" +
                                                   "5/q+/cnORF3blysew7/+G5/8d/6m/bOTE50cVxOP/s0XvXJvK1ekPjLpxiSl" +
                                                   "N67xaNLkOHfj0k5vBH/uBvDHby1wVaPbstltbnFtvnu4zX3Hbfy9zfMRYnsN" +
                                                   "tU+swpp/4y9+nPzXfvdGzxOruO7x8eF5z2HaTxns8i9n/8eDT7/23z6Yvcua" +
                                                   "fegW5e28Ne20uwrcmuJ0Q94P8rNve8v8W2PuXYD54mOr/8SzFvnUZ5+1xyce" +
                                                   "a3q/Ql/f3/W0CU6M+PCVSVd+fWQ2e+De98x19kPltf3w8Mrs9rK6LfmeW/vp" +
                                                   "a/N9d3K5vn7/ncq1s/cUj2z0kbg+cHOUj033zqiu7fIxCu+/ovD56fno9Olf" +
                                                   "ve//4xeg8INvg0I7e1dZx+fJTQyPN70J/333m/1H9/2/99SmE5/tNC3cW9LW" +
                                                   "mHETT9r8Aq2YtCybTPh8nzf4P/XVn/7DN77y1QdPJVff+1x+8/SauwTrxqH3" +
                                                   "3tg0TF/5Yy/7ym3F9n/9a1/+L/6TL//kXfLxkbemCpu8y/7q3/1//tYbf+Ef" +
                                                   "/toLotO7nKJIfTt/W25/3/R8bGLIN+/7v/8CbnN33L42P/Q8W6+r/t59/7ff" +
                                                   "wtYPTLhpnZPFTXPl7G0pdU/4tdu1s3dMaerb4gZPz3fNZu/443f9gz98AW7a" +
                                                   "S3G7rvqD+/6fvQW39zVPIfZ8YnlzRXdy/v1v/Nbv/sa3ffIXbjHxVWcKJDfr" +
                                                   "eTYjfz7hfksefZP6e95K3z1d7/j4i+h7ZDbvvZmNbJf3lgQ84wiX18Z6xI4f" +
                                                   "fbFhPLjZZjt5hTi/95KTjb6W+nl4l+zJ1+Y4PP7Cg7tlj5C4c9I3X0umRe5f" +
                                                   "/f2jubsUJy7eeHz4mSaH53CtZ9/zDI+FG3ueuMqfF77xa7vvd3/mwewdj73c" +
                                                   "c6eVty764lt923trfzps5fpbPNx33THoRuC1+WMvCQ/ZS+ZuCXIy8dC9cuAR" +
                                                   "9R96wpk7Dz28rTqD0/OJSdxfu+/LF6hz81J1vq4q7vvorer8lAd7hNqHr/Hx" +
                                                   "SWAV7PIp1O7M8JXJY74TegN+A7r+Hl+sPO+4V57XmtsB+PrLfqRC33lK3dcf" +
                                                   "5WjmpKITAq9P330Be+4OjS9AYVKNDzwB44vpZPln/tGf+1t/9nt/a3Jo7Oyd" +
                                                   "52swnDzfU3uJ3fXo/RPf+Non3/fVf/hnbqnPpGM/8he//M2bDf3pa/Mnp2Pp" +
                                                   "FTut6GrX5+2mFW65iu89RvAZZ/TqJNgXIdg+nNFwwxCP/njQpQ69OTj7wL9g" +
                                                   "SbSbk2bPRAdyjWkYdzDCsMhYQttdiDRkogISL6imWh3aog0agmv6UgKFt4/l" +
                                                   "QQPHBe+Yqz4obbJt84VpBBuq5aA9mDq23Jh5AACmWdMxsTqfzQM4js0AjC7q" +
                                                   "HXZjcAGAQ+YsRxdDhVyWgmuPSisgWWmQbRHDDj3stazl1ZNR8zhr74YDZbKS" +
                                                   "6Gc1b6e1kcsneD/iPJS3LJLHxpbr80BXR90rjX1r7IxKTeqD4y24vt1Gudts" +
                                                   "6dKoqkta2pXdroUKrdb45lzYnnDZkmCbWVBiR2zJMAK4r7iEN5YDuNO84uAd" +
                                                   "re1ARSfHSFuu5aZNq6YoopZVI3M57TawnG2xkmqGlbtMdMxROlRL7DRKHEJu" +
                                                   "JQ7wjAlfc2uczrhLnFcVSqkctAzkoXE3kTXaq4Mn1Whd51hDBydku15hSch7" +
                                                   "YMJZ9r4SaX3bQbLfcnMFAAtDAUdN50q29XVmn5q6bpdRZSct2ZaqvsTzSHP2" +
                                                   "aWs3DrezK0TTdchcq3t+3F92XkTbLdE4Go1lSTaSixBEJWLfZmXJLWt81a5s" +
                                                   "Q2yFmAEvQyPRpqJnpmpild6ahalyle6xdYJYUhj3GzLzha0JxFstKo9Hj8N9" +
                                                   "YwFqXbsgWG2ktIPRsq1pLPeFfXBs8eD77ZEkjnPu4ij2ltskYjwhWYtbrVFX" +
                                                   "J7/f1+Z+E4aEFvf9obps8qoy1bA8YsApQ47dTqpwnl+kdOOCrFhy1DzQIrUz" +
                                                   "yIWWgSal7z1jnUbzZSJ6l+aU1z2ihXErby/FKNXYisUlXl/lcyk71QJSaNbS" +
                                                   "5NWzGYl7dyk2F0zcX7IqH4/9heyqbI3li5M6JyDsdDYhNVk1xhGmpW1WHqBx" +
                                                   "ZRrnA823PVCghsdBeaQk+FZbhgBbaBv+fNmFJRjEcZYexYzkwXITiezy3Aen" +
                                                   "RVmKrrhPy7TUWme/gMwq9nEjjYxCEs9cxe4vIbsxN/G5PWi1k+L5lmu8Gm3G" +
                                                   "iF2TQDLfLWQsBs5YnZ/wMtHaarscjsdVuaN9M3aqk7nBEyk10JDanyeE7Pqg" +
                                                   "G6C7EEnBM7MFVmSiWVFMWfK0Bjiro+4e1wU753fRUOdWK+wXIINw/ikY5/h6" +
                                                   "J8LDiEkWE3FVqFMKwekllHZJaceavYG8lAeHlZ3PR30lS5FEaEUabtHSiL2B" +
                                                   "YxnRi4RddjSqlBNbmtWPoD9fpWIKgovBhU7HQRUzd4lXGzJa5XHg2uDAGwS+" +
                                                   "a4RN5O/OfBO5jS+7C6U7lbK3smNdnBTEvNh2M5QFj+8v9q4UI73dVKlXWeK2" +
                                                   "gKqj0Y6kpgwxcyJQW10aKmfVkRDu+kV0WG0lYptC6mUxdzV6DaB+Vbf6QmNM" +
                                                   "QmnUklEsOUWMcLXJQVIDMw1F7QOdYv4xb0Fro2l4JXanI08Vl2bDp8eoAzIT" +
                                                   "afeLxVFbYqvz1vFW27XmCt1eS4Ea8giou+yZE7yF5aNaVRaGb7GCjYOlgkDn" +
                                                   "CG0JoRSEY55QbR+fFC7Gq0vXA/iZC5BEZUHqEIZjLzVGBlYncEcgoaichX7Y" +
                                                   "HFQ7EU3bWUBotsRcPGBRy42jXSySDrPjLmQ7xVGyS4wKiTrZO6NLgG3RA9yt" +
                                                   "Gl4qRuyyLHl1044iw5EeDvgkMAaylye0BsY2Mre3O3ZhiDSw7PbOJoPszXSa" +
                                                   "s0TbyMpQluaUVcCr+Rby+iGTNid1E1tmiIy60EvQWVZJtwNlfo7XksOxrECV" +
                                                   "nc6O1bjlpVZPz4LSpySknACkPQ/j2Goy52SVXqmLRau1prhbbCxjrdi6OMxF" +
                                                   "YahVvhuPx0Sv/NFnhaWIV15LRYgtXsLGJmNJp+NwvjUzp7ZbkAoCdyssthGr" +
                                                   "4URRkX2PLCu3G6mhp31oaR3oNVkfOtSLLkVvABjloJBpyXK6DuRLKm3mK9Y0" +
                                                   "xuM+tHbgyVicXbA9IkJclI7u84vytNuVJr4ZfHejM7YmprLR66TerMsz30HS" +
                                                   "TiK7blAo/KhqmUeIDL1fLZRo2NNiDFWQQx0g0sRWvJtspGinuiK8IBNs4AZd" +
                                                   "Yn2hWPJ9QwzNiXLao1m27cJd8hBGN9I2xyFk4LMYC1acwoFbbNV0doqglTBX" +
                                                   "cYJShHJr26C23denTI+dzTBvAGu5WrUXGVpKuikC7raTaYoA8U1a7kI11g4L" +
                                                   "urA14rATvHhZdRpB9jAwlwCgWVAsjjcHZjjicUgQhUqchAJE1xuvpEzgANCL" +
                                                   "EuLAPN+tQPYCB4JyLkvXO0vKvkbCDZHMW1rB8XNAnBFoxHT1siRggSXC3g1T" +
                                                   "olCoKsBVr40MfA0lyAqfAIB1d6Z90MajKfoVIbVzjW0Du56UbjU/Ohx4Sj1e" +
                                                   "wG7rsKmxVAPdOsY1SkdpD+xyMvVxZLtZ2iXJHSlxb8nVxmOyOlzvDczQLJmc" +
                                                   "G7xxPmObCFwc9cCxRwARDzRKZD3I0pwpY8TaqM8C0WWyuVvB8+BQ1yoC8lJU" +
                                                   "nxUBd7vG3q2y3QVa7M4XcEHoPLNRgsugjfmhko+r/AAC+OoIFsgGdehuTqHy" +
                                                   "KsNdL/DkOaoe1naIc/7SORPbuE8jNQSOB4Ran6shP7g53MU0dhBWlXgStpY6" +
                                                   "pgANXM6EInKrfnGBxrWxXjSB1xMMTafFee4C+ySnlHW8wnLCa/aNDko0qTVt" +
                                                   "VxHUCphShyZURlQlm16NFKFwFsWJJ1a7ATcP6Pm0qpDzALmCPemlNdngQooK" +
                                                   "sN4aWCjK5+h0klVMOcjqIolOntuTlVQva5PjwgYIKNAr2QQ88+SakikPvwDw" +
                                                   "UqriZZFll0ZlBlxqdpIPw1qFR23ZQ6bLOD4Z6FwwH47qZjNezjh8XG6OzCFD" +
                                                   "1onMHXXGykipOJOIqfHtlJKllqLoypjNWWcIuB1dL/acx4mitm8W48nDz+Eg" +
                                                   "dlaZkCiF0vgFOqP1XJkHJ50Eybm5bfftcMaVDTcll84ypOYLicNWh/2lcGgL" +
                                                   "HkhhSnIbLGLDtDvolMjxpSVvYD20yca76FEwnjeJQPOBgpkeg+p6CGZTQlBr" +
                                                   "EiqiOj8aMUsEYVn4bcB0RlysoWLZLJQAkdKAlmrWAi/hBTaXetEaKL07oVYD" +
                                                   "hFA0IBC068oNsYcTYIdtB0A6O+yyX64yJZkf0bOJNTI/OGuol4/ny2Enxvvh" +
                                                   "CDe0lR8lo2+4FKsOlTtZCrJeHI9pBijHMd815hDC0VGeiwxSnIBTMNCr+SXH" +
                                                   "lFFUCCrz6pOJmSoyxWrD6k4XoaY0ii2uKatsV+QKIFa0H4jeQa7OrmsGRrNY" +
                                                   "jIyz1uHqMJzohmB5n6gbe9seGcM7YBOOe3aNep0F2fMlPy8bSvPQ4OQ7I4rs" +
                                                   "/T3uoIti77t76RAvtmOaSqYm6kdoylXpJRAJB+iILf0TdZSOvVZxO6o7tlt8" +
                                                   "n84NfS56G1JS0IZKymUvJfYcTv1eYqH9OrMX6JEIVwa3w9Gqa7DzuYHZbX9Z" +
                                                   "XDZssOSW0BhJQpbX2Vk6LcmlgWdTbqS2pDcRtyIGegCUHka6iKhLmUsFy62W" +
                                                   "AgLkYgr5MizmwKIxU6aUjzQaA5Y9enrDCGOPry7GZsSyFZKG86PDkRNALQIU" +
                                                   "YHbzo7k+9qccDyWXVqUOooA2QGzXHrNmzlQyWbUebNUcn7C7C1tjQVySdLP2" +
                                                   "5e6whjkmVAJ82waStfZOrXlkuq4ElRQ90mw4TgaxU70YmVDRN6xOwJdsQ134" +
                                                   "xQYjxEMty8CW6jFqpQ7dpbYWNndkE3YdHfUwn9OehfXMft0kTBDNib6WkWO/" +
                                                   "JQlTaV264pE5lk25MxMS+2TXsPWUnJ7IhiaNbaYPC2nA1uMSjswD5mLbJli7" +
                                                   "u7UVe8Th3Lu7UYhGwQqERizzdOFiiUSH+JbwCFzL5TlQU4qOjTShYaMXFnuv" +
                                                   "IUnBYskdTxHxGhYgTDkxAalZg865AB1f1vC+n9xtAoWtETDVhiWELb23NklB" +
                                                   "MsiJn6ONfR7gDaFOqct21/mwEkK1G2SMNG9iN0khB52PtbauVzXpb2XpRGM0" +
                                                   "sM2bY5DUgkjNIRSYMpNJW9fHuXPSkykla8xEcAaYWysYNt94iL+GgXO3FgR0" +
                                                   "by3gkBRC69JnHLZYS9VRCcETQOSUjDC9R2EQL8W6q05n4BhZCmvJmFxC6/oc" +
                                                   "J3CKCx/3lkQpCD0ygUaig99ZhLGefhbKEZ3v2YPt4PKF3l3aDOWXmdpyo9la" +
                                                   "C8oxlWNuO6YZowLOqk4d0MVZRDPPhBh0aEPJlnMVtDesGGPqSK+SmB+sAM+F" +
                                                   "JDS8dSEcycnNb0d8Oo8KizlWxpnhZsX6NJ8DDh5NsbpsMgGDWL8d2BY+rGVF" +
                                                   "nfKPizyi+7Q676F+M51R1hx1EfZsd9yRAZJeALfiePaA4fMhHs3DQY4HZnem" +
                                                   "IwhCUJPCAkoxSxmKdiSSVMle79VwhO09fkExSJflU32KQTVmwXIHcCbIgnEK" +
                                                   "dxuOq2mLEr0zaPIM2l+8vUULQZbYLG22ZwyaIkmFuCHgcjHXBz0FafkF8JlY" +
                                                   "JrcJoEDEhT1F8So6VAkbhApBlBvktPNkK2H2aB6QlnfSGIURw0MfIRtP38jd" +
                                                   "eifhqtVoO6ub6+5GPQGaC5w5TOGJMlEyUj/sYrKKvKv8lqxqR1C8qYUsJuTN" +
                                                   "BVxZG7iN+dURXhfKPp5g+a4+4/t+OnfqWS3VdNxQyJzLOLTf1YeRqSxfIOLw" +
                                                   "oIAbAFScKTEzPJ1XVMJOexyG1pzF9R4NEjs6hDsyZcuuwU8xtCcwS3CrapnL" +
                                                   "AE/vIBWT9tDBG1SgVZxmr+9JV3TsNb7LxTJl6nxKTkpZOMpw06ixNZx1UxoN" +
                                                   "xx25kNWNfIvuoRqgwyM+j+G0WJ1o57SoSvMMoeq4Wu6P52BpAqjn+2m+WwYs" +
                                                   "2CZsldKq3fb8lEcYLBrsdNNeBkuxA2MkAuYNRyPhOIoijIfokUlOGbzUGHxr" +
                                                   "nu3EoXtaOnM0jGOOtKF8HN2Mlk1sE2XeRMN0zDjPhQ53WtVMo7GF5pIgnQA6" +
                                                   "t+UEwcwwytYbFMOpS6DhgGuysYXom3wDiT0rlEHFVnPQyg64U9ktsLNOyXSe" +
                                                   "OC0CylvkhXrs8bm2QREmcGOcX2w1tQcNptrnoLUyMzdNmGjyd/XlSO9FB2fp" +
                                                   "Hd0sdLQs6aw8RRferMempyq0kpbHrevPd0rdZbvT0dYOJElzFRCtxDA5FGsM" +
                                                   "9omTG+/YfrsEcjrV2/JiqQcCEhybR4YpzvhiBge8giiDstKnfANc6whAW0hE" +
                                                   "kkY4cBPH7GKO6z6Fcsx5yp/OhtTuq1NWjXa97qYATIasn7h90RngiaPWoQWf" +
                                                   "DrB5XEKVSuchFmTslONEjQAK4H6BV2VpRrl2srHOCQEbl9R16Z4YPEAZpuMi" +
                                                   "ZtMkjdQ75JSZQRe2l9b29DOfPNByMZ207AWc8Ayx3gB1BRK4LCJUEWQb1UgX" +
                                                   "u4qmtu0lIsYpyzhJedX2iUwgbQodpGS7Q7aF66hJsjdOXGQRJDPvWZo+Ob6D" +
                                                   "iiQ4b+YKhESDBit65rtoxSK4h0gKT2Xw");
    public static final String jlc$ClassType$jl$1 = ("XunbfB+J9eGyikilKIcmts7Ueo0qcOE0qgd1mxgRlNAPkF3twkM45GtvBHTE" +
                                                     "ZHLJAwxpcxEdxknsJOt6Dve0s71DzvpqCvNkBoOMFOWuOKLuxpMPMuA3nDpy" +
                                                     "3ISDjYA+17XFaSVULMxRS1Pnqs12aV7K2t1VVQ2gxAGCNqYL4oo595D+NIdl" +
                                                     "VdJGaylBx9XCO7RY0QrOnBEKGkZY6sxjEYL6R2Gh4Uh2EJzE7xtNnKPQAXKM" +
                                                     "vAt4YH84Eh7jbbeX9cpKLA71OVVeimZMLxtM71QXOM3FDbvSAQ7ZMbbe2xt/" +
                                                     "vYlWDToeSoBhDnLQnczW00eG7kR14IsWkRsp33pYRvWtkA5RK5MI7grUKI+g" +
                                                     "ZeSuIS6zmFSWPkQkGIZYhgsb41IZwUu76rm2SnvP3G2bYgWZfbMCjqQzuq17" +
                                                     "yhbL1cbJDrYoLwmq0XAUipfdbreETwWSM8SK2C0vOseiYrtOOaM59Ay1StdO" +
                                                     "FbOdyMX4Kh3SbjmwIHPUynHCbTr0y+xx0SOunMIZT0Z9gh2lEiCQNUUCcbpB" +
                                                     "cDEfLjiM83B21rLWWaxG6Ahkwbm7gCOGwNd/z4AQIeoWHqXkUBA6LHUZNejS" +
                                                     "iBzdsttWZPMTFZ19MtxtHRDtViaNQngsLkV/Pyx2FsYchg1XBR4FOfEwkNsM" +
                                                     "zFdTxEkdojB5Se87mM5AW7Qlcn8UKw1NWjXgKoLNRm9RVogB+ocVsVx3c0Fe" +
                                                     "zhGv6pXFbkQimz3BxmLBhj1iw6XZ4ktEPozn3IrZKSnskfmwISPdB0V6lyBn" +
                                                     "38unU1m3P23sKDzOt3luAAW2ppbjnJurl93oIjG4EvdyZLi1wxPU1h0SS/Lw" +
                                                     "k81sGBFps8Uq1xZHcExJdGM2vTvPAXU4W+iuRgFfLkJTmfxJjhN7fxxM1duW" +
                                                     "xMZkTQyv80sVkQavMmCnYcZa8/oUxcbjQag0ktObzIWhZq0tNN1ea21iKpgr" +
                                                     "uZYmIuvBpmNjL8IInrtefLB3wIJjKewwZ1ZjrcAUbxmInNBiqXNkYXN2AUEX" +
                                                     "E5WmuZWr5adOAph1dF5sRf3sTFqCdkxfqQJ4sjZLidqKY0tEqOCOKqctFNDv" +
                                                     "96Gt8bGkWQcHaxifCBsoH/WzoibSvpjvDFbvpyAWhbA+eQVru9sjR6ZJ7EoD" +
                                                     "ETgupq0RY7ASXCQtPbH9kWa33lgU5ED7S4UF5v3W5hfZBaHm8EAl40CqFLyH" +
                                                     "FTVok0XLc7TYmEWoYSqNSbIwqrYIo+0ZiDxFZ51yqM9iKCHU4phnQTOdYGGN" +
                                                     "MCh16DP3PLo21zALDF7TYrpmTZ8oukXAIXA95TksKFU+Psy909bx2KN+XJg5" +
                                                     "PpCj6vuIYLYLOStzwl3xq1qO16AZKF1lb/iRUFBezdSjxTOrswC6BtikJ06s" +
                                                     "tscdlfJKvzFzpZcYNAVc/IztgsI2drILRT7romc12wIMbiJn2RJ25oGZyyuy" +
                                                     "FnKrCCSH22eehOT5GvCh+nK60NCK4QFHXAonULHGrSzSvJwEgrLabYgkcDYK" +
                                                     "YbJEspkyUSjuAVmN9o46Vy5DH23HHlubWkeS5YQkCbjy+VAtajMZcZikiHnn" +
                                                     "MdsNTZ6TVBk5y5QBW2DbDM7cBRj7p8FRS6It3JOFFrRtnchio6v7C9u0E5M1" +
                                                     "GV4YUIev2bW3My5d0hJFsRIXqmqiHRdWShtB8hFkc14yKPGyTA1c7XwAQVer" +
                                                     "blQlZTrGjuO8LtxFKTRQ1I4O1WTgNsqPZVohNDZczutq4Sf63lV2TLFUNmOv" +
                                                     "Ef7uDCi04huKJfFzCmuI02bZG6HUYIoCgLllKpFCXg5ikGLcen3uQdSFV3zX" +
                                                     "xoQyN8w5prRISi7rfMPuGPTgNPA8SMe62Jy7LasYy4sk9wJzGOGUnzwIyHWe" +
                                                     "6C+T/RwNNH1bRN4WrvbdUpGRxN3JAEGQLQyMe5oPxWaZE35fM/NuXAXnE0mt" +
                                                     "uLVjNCGHtSGQTFkJf3CYoKtqa9vqe7GcW8kGLITtvo2IAY4lH8rx5WZdMp7M" +
                                                     "YwgOa3sV6mCZjwljnPPYwtuMdByfg+QSxv7EdQxahgJVVDy4Z3dbvl+6lqNC" +
                                                     "CwaS8rB3pFSBUSZfYluaWclioacwzEErT691yC3i9ZwwEh1fF/owBBY8V6Fk" +
                                                     "a7W02/NiiZ7KfHucZ466d6m1rMKZ5NNrQt0FF+B4G9sVc9YWOOHY8dZmAWwu" +
                                                     "1DJL9llJAXBzqeEzV80va7llXO2AZZafbnauCjX5ktIpUcILdKSWFAsPeGKh" +
                                                     "9FZTzkxAJFVBotFljWyXk+6qm3IQN+d1SFapwHBJ5KeH3D4eLgaOFU3crcs1" +
                                                     "VjBeXrAGFecY7BpyquApLa0iwIPiklppDGEYIZS1PqAZR5Oo0tMeEZdRQhXU" +
                                                     "+Riq08ErD0tiBaMHr54brtyJVCeKCNZ7TXNBOSG1lfNlMqBiCkqdtsgn0yGn" +
                                                     "YVw1k9jUdN+HzlefbVGpCXY61GeK1WNLac9vTtK2CC8t04atEsjFRN1YQFgm" +
                                                     "pcyZj7AaUFBa6XibFqTLoQOhrB5sHeaWDtJvJdKjGzgJJQ2HcoDt8fLQwQd8" +
                                                     "Ae+xHhGQKQvmdp0MgIuQGU4165BMWgZoqyt1eahdfrzE5ZaCQL5O0TlFNvpO" +
                                                     "AuGLiQPk9jiILj9cnHhT2ZEonrA0H1aohrtcX60pe2TIbLwIodsDY3NRcz0P" +
                                                     "Na9xfKULj0blS8LKinpJlsccgEJD38FEBe4xqu/Gs73ts4Guij2Gn0LLdKNG" +
                                                     "Bud7hNGVpYssTL+V0GO+XurwEI3irheDwaqm4CkArmv3AL8MGq3sT5foALvr" +
                                                     "8gL70g6jkYENutDo1+eE7i3BmhJ1188Uhj/lU1IeZkoKlck+rAMzpjzGClsd" +
                                                     "ylOaVMZdgLXNqVsb139D0fOGNXbEAemxERkWKSwrw4gBjMC3Rsjm4ynijXm6" +
                                                     "3m0VbiwcJpP7arvU60Z1+S3IF+EoOgjtKGiAg5QnYBQVkBuvgMZmNwWtjhbq" +
                                                     "hbfQvW1wFIHK3aJzlXTiEqL3PTHFnTR0eqIhCYR0JNBnRpfKyGQFpJIPKhqd" +
                                                     "hbGEEPZBY47M5gQGmUvDaZu4fCjoDH1Re7MQaBVbl6wATFZPlZvGps3tlceE" +
                                                     "dS0F+On7qoIP32oeHlfNn+LgOvHjLyocePA7k29krCaz6fWG20Qi6jp7nqQE" +
                                                     "ZjOlKdwownsEaGABOjZloyZiDgJu19BhdXAX6FIhy222XxwsxjK2c9q+JeVs" +
                                                     "Al7YiXatGNcV7RwU2tuwmmUsFErUtUuyNPbu9sKsncFpmXXfqdb5YA1127Ci" +
                                                     "Tx6LNs5ph2FR29fWI3zeUhtvDVdHzlmj5yJ38gOLoniORZSHG4TFDLLs+svi" +
                                                     "KADbJsJRWLx4bmskA3UIT5u0jmUAcrIloex7pjivQaenm+W4HlxiBXmrNXk2" +
                                                     "/JBAcYes0dCfjothSK6HnRcTcyGJRicP2lJF2jUGtA0uCAkbYigWycIcs90Q" +
                                                     "OIWu21xSCUxD3RddXJecU5dhPeodp+herC9Ut09zzu8PsOclOmymMqtPYapv" +
                                                     "4ilW2NsLTLUmnAU4vM6SpCEPSpsfeFVG8X6sBIiXszaw9ki93F5iHuCaEqqA" +
                                                     "3udgXigcu6q28XSolwc3QI4X3CnXPpaFzqEeo4CVyY0jXXRBhAStVJmznY4r" +
                                                     "IpI9HuUxyMfcbq5msEXAyGnuXqB+SLJ9cKxAKaABdMqzIxiRpIabI6U+nnX/" +
                                                     "ADekH4OW6/kFhhe7A5QrqhsbgO51eahql1JNZAm9BJ1KIkun59IEwnN4J283" +
                                                     "0CI4+M2SEhGt7mH+sDkhw9nVEQQ+41A6N63GXTL68lDXLt7xLUDz583e7rya" +
                                                     "MbIwgSfFxAup76Vmhdd94AObEx5ZqbzNsYrd03XgmkVz2tUrsOHkockDgZsS" +
                                                     "4TnK7IV5f1BcETlnpksQxA/+4FXl/817A/n25wzkdfBtTOSu6unPvaRqjXhL" +
                                                     "vdF3Xze7FW0/W3H/pnQF+fztE8OTKqrvfVxFdft77f4Gw3953//SU1VUTxUF" +
                                                     "z66VmZ98u8smt6rMr//pr/6cJ/0l8MF9eRjdzt7TFuXnU//sp09t9f7be/wY" +
                                                     "jfc9ulDxqdnsHb9033/96VKwJ1x6hoIbZu+9X/If3vc/+ywFL65e+/dfMvcf" +
                                                     "XJt/t5199MrY159l7OtP8InfWtD2uen5gdnsnd9/37/2EipeUM12XfLOu/7V" +
                                                     "P3h7Kl55Ul38w7ddf/4lpPyVa/P1dvb+rgxr2/NvdZO3pS8Sw8Pp2UyK8PH7" +
                                                     "/p3fmhiuS16969/9rRDwiy8h4D+9Nn+1nX0osnMv9Z8qn31Rwdq5iL0XETaf" +
                                                     "nh+dpPR37/tf/NYIuy756/f9X/mj6dd/9ZK5X7k2/3k7+0Dot88QdHwR9tea" +
                                                     "5GA2+7afv+//7LeG/XXJV+77n/oWxPI3X0LCr12b/2YSy5UE/4b/XQ3idVx+" +
                                                     "kXFcy9ib2eyDH7nrP/DNb804rkt+/77/x38kIn78tuvffgkRv3Ftfr2dfee1" +
                                                     "tnbyZXFw+efSchPIp6fna7PZtyP3/ae+NYFcl3zyvv/OP5o6/eZL5v6na/N3" +
                                                     "2tlHJtO+XjQinpS+Xmd+6e1U6uuz2Xd85b5vvzUKrkua+z77o1Hw2y+Z+0fX" +
                                                     "5h+0055+Szx39eBFRNyu4V397Cuzu79b385+8/n7UQ8/I/32T/zMv9A7US+6" +
                                                     "O/cFcIl9brn4/BL+7BceVp3dxFVXtP5n7m4ePbx6pofXYB3n5yLxKT946lba" +
                                                     "Zz778MfaKG7eeHHA+cxnv/jlz5bl28vl9vfas9y4zv5OWb6E7//kJXP/27X5" +
                                                     "X9rZx94O6ReJ5d3X5R9+Xix//V8+sdxdi3laLnF7lcPDH/4R7eGL2P1Db2X3" +
                                                     "u17E7v/9pez+py+Z+z+vze+3s3c/wuVF7L19/JPPsfeV//pfOvbelcY/vFf+" +
                                                     "+0s3Nz4/uqpQBJ/54dvti+voj9mZ8+VbKfvd2+MLbLeft3XS5x7eg9tn+1n4" +
                                                     "u6sGd8DFj2wnMcbBw88UD+PHH3v4LPZXUT879tB9+IMPP/McZPHFh3cXKR4+" +
                                                     "f8POuN4n8Ktu0qZ0Yq1efMZ94yU5+edupEz2fL9hYKeN/5x1v/i6yrX5U/dX" +
                                                     "GN+qSA+eQN0S/uoK9crs7dXtlRvs/zWlIG8VyXV0+7TSPbp5+rFHyvZo4Dr7" +
                                                     "yf8vsH7PS7B+37V5tZ196sZhu2lfzOYbTsOUnDw7cb1f+bHn/puDu8v47i/8" +
                                                     "3Aff/Z0/Z/y9u3tNjy7Mv8bP3h10afr0jcGn3l8raz+Ib+S9dnd/8MaSVz44" +
                                                     "JaNX3K7vd7GxGv5fZn06E2hBAAA=");
}
