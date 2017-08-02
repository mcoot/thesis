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
    public static final long jlc$SourceLastModified$jif = 1501637906413L;
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
    public static final long jlc$SourceLastModified$jl = 1501637906413L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM18C8w03VnQ/t9/6ZX+bZFSSls+yw+0TPvvzs7MzkxrDbMz" +
                                                   "uzu3nfvM7g6F37nP7NxvO7MDJUgiNBirwRYxChItKloxEMEYxaCJAoEYRSMQ" +
                                                   "gxBiFAMYMBGNUXB23/e7f/8nTdDwJnPO7DnPOfPcn+d8ec73+d+cvFhXk7tF" +
                                                   "npyDJG9ebc6FV78qWVXtuWRi1bU2DrzmfBaYfuYvfOPbf+T5ycvm5OUoUxur" +
                                                   "iRwyzxqvb8zJW1Mvtb2qJlzXc83JOzLPc1WviqwkGkbAPDMn76yjILOatvJq" +
                                                   "xavz5HQBfGfdFl51/ea9QX7yVifP6qZqnSav6mbydv5onaxp20TJlI/q5mP8" +
                                                   "5CU/8hK3LiffMnmOn7zoJ1YwAr6Lv0fF9LrjdH0ZH8HfHI1oVr7lePeWvBBH" +
                                                   "mdtMvuLxFfcpfoUbAcalb0i9Jszvf+qFzBoHJu+8QSmxsmCqNlWUBSPoi3k7" +
                                                   "fqWZvOd1Nx2B3lhYTmwF3mvN5N2Pw0k3UyPUm65suSxpJl/yONh1p76avOcx" +
                                                   "mT0krd8U/tinvymjsztXnF3PSS74vzguev9jixTP9yovc7ybhW/9Wv67rXf9" +
                                                   "+KfuTCYj8Jc8BnwD8/e/+be/7sPv/4mfuoH58qfAiPbRc5rXnM/Zb/tX7yU/" +
                                                   "hD9/QeONRV5HF1V4hPKrVKXbmY/1xaiL77q/42Xy1XuTP6H888O3/i3v1+9M" +
                                                   "3sxMXnLypE1HrXqHk6dFlHjVxsu8ymo8l5m8yctc8jrPTN4wvvNR5t2Mir5f" +
                                                   "ew0zeSG5Dr2UX3+PLPLHLS4semF8jzI/v/deWE14fe+LyWTyhvGZvG983jQ+" +
                                                   "//q2//Fm8ieoj35Cr71qPe5Sf4LKnTb1sqb+hJ5Fn2hCr47qTzhW7b1WN60b" +
                                                   "jRCjft9y/fr62jHyP1FXzvXHJ8j7k+q5brz01XG2+P/wjf5C5xd1zz03iuC9" +
                                                   "j7uDZLQdOk9cr3rN+Uy7XP32D732M3fuG8Qth0Zdvez+6uO7T5577rrrH7kY" +
                                                   "zY1QR5HEo6mP1vzWD6nfwP6JT33g+VGbiu6FkaEX0Fce1+0HHoEZ36xx79ec" +
                                                   "l7/j137n7373J/MHWt5MXnnC+J5ceTGeDzxOYZU7njs6pwfbf+1d60df+/FP" +
                                                   "vnLnoglvGilrrFFrRgN//+PfeMSIPnbPIV24coefvMXPq9RKLlP3vMibm7DK" +
                                                   "uwcjV9a/5fr+tt8b/54bn9+9PBd9uwxc+tHrkLe6fve+sjeTVKwCK4tGzfjV" +
                                                   "b/+uX/3OH/joH6SebEeKL7rxUXD24fniIxBW3GjJRZiPMfDqaz+uFt/7C//i" +
                                                   "P0N3LoTfc8svP+S/Va/52EOu4LLZW69G/44HuqFVnjfC/dL3SH/+s7/5HV9/" +
                                                   "VYwR4iuf9sFXLu2FLdbIjrz6Uz9V/uIv//vP/Zs7D5SpmbxUtHYSOVfM3ztu" +
                                                   "9NUPPjV6iWT0VCMm9St6luZu5EeWnXgXxfxfL38V+KO/8em332hXMo7cyKqa" +
                                                   "fPj/vsGD8S9bTr71Z77xv7//us1zziVKPWDHA7Ab1/fFD3Ymqso6X/Do/+TP" +
                                                   "ve8v/qT1vaMTHR1XHQ3e1Rc9d2srF6TeOerGKKVXL/Fo1OQoc6LCSq4Ef/gK" +
                                                   "8DXXFrio0XXZ5Do3uzRf3l/nvuQ6/ub6yQixvoTaB1ZhTj//l99D/vFfv9Lz" +
                                                   "wCoue7ynf9JzGNZDBjv/W+l/u/OBl/7ZnckbzMnbr1HeyhrDStqLwM0xTtfk" +
                                                   "7SA/+aJH5h+NuTcB5mP3rf69j1vkQ5993B4feKzx/QJ9eX/DwyY4MuIdFyZd" +
                                                   "+PXOyeSOc9szl9m3F5f2Hf1zk+vL4rrkK67tBy7NV93I5fL61Tcq10zelN+z" +
                                                   "0XvietvVUd433RujurTz+yi89YLCR8bnXeOnf+q2/xtPQeHjr4NCM3lDUUWn" +
                                                   "0U309ze9Cv8tt5v99dv+rzy06chnK0ly55q01UZUR6M2P0UrRi1LRxM+3eYN" +
                                                   "3qc+852/9+qnP3PnoeTqK5/Ibx5ec5NgXTn05iub+vErf/RZX7muWP+nv/vJ" +
                                                   "f/g3P/kdN8nHOx9NFVZZm/6df/u/f/bV7/mVn35KdHqDneeJZ2Wvy+2vGp93" +
                                                   "jwz57dv+F57Cbe6G25fm655k62XVz9/2//IRtr5txE1t7TSq6wtnr0upW8Iv" +
                                                   "3aaZPD+mqa+LGzw+XzaZPP81N/2d33sKbuozcbus+t3b/r8/gttb6ocQezKx" +
                                                   "vLqiGzn/1ud/+dd/7ove90PXmPiCPQaSq/U8npE/mXA/kkdfpf6mR+m7pev5" +
                                                   "9zyNvntm8+ar2UhWcWtJwGOOcH5pzHvs+ManG8adq202o1eIslsvOdroS4mX" +
                                                   "BTfJnnRpDv39L9y5WXYPiRsnffW1ZJJn3sXf35u7SXGi/NX7h59xsn8C12ry" +
                                                   "FY/xeHtlzwNX+YPbz//05qud77ozef6+l3vitPLooo896tveXHnjYSvTHvFw" +
                                                   "X3bDoCuBl+aPPiM8pM+YuybI8chD58KBe9S//QFnbjx0/7rqDI7Pe0dxf/a2" +
                                                   "L56izvUz1fmyKr/tw0fV+SEPdg+1d1zi44PAurWKh1C7McPnRo/5IvQq/Cp0" +
                                                   "+T08XXmev1Wel+rrAfjyy7qnQl96TJxX7uVoxqiiIwKvjN99CntuDo1PQWFU" +
                                                   "jbc9AOPz8WT5p//Dn/vZP/uVvzw6NHby4ukSDEfP99BeQns5en/75z/7vrd8" +
                                                   "5lf+9DX1GXXsG77/e17+zcuu33Zpvnk8ll6wU/O2cjzeqpvtNVfx3PsIPuaM" +
                                                   "XhgF+zQEm7sTGq4Z4t4fDzrUvjN6e+d7ZywON1PS6JhwTy4xFeP2ehDkKUuo" +
                                                   "mzORBEyYQ8IZVRWzRRu0RgNwSZ8LIHd3kdSr4DDjbWPR+YVFNk02M3R/RTUc" +
                                                   "tAMT25JqI/MBwDAqOiIWp5OxB4eh7oHBQd39ZvDPALBP7fngYOg2k0T/0qPi" +
                                                   "AogXKmSZRL9B9zs1bXjlqFc8zlqbfk8ZrCh4acVbSaVn0hHeDTgPZQ2LZJG+" +
                                                   "5rrM15RBcwt91+gbvVTiam+7M65r1mHm1Gu60MvynBRWaTXLbYmWS3x1yi13" +
                                                   "e16TYJOaUGyFbMEwW3BXcjGvz3two7r53j2Y654Kj7aeNFzDjZuWdZ6HDauE" +
                                                   "xnzcrWc5y2RFxQhKZx5rmC23qBpbSRjbhNSIHODqI77GWj+ecIc4LUqUUjho" +
                                                   "7kt97axCc7AWe1es0KrKsJr2j8h6ucDigHfBmDOtXSnQ2rqFJK/hpjIA5roM" +
                                                   "DqrGFWzjacwuMTTNKsLSihuyKRRtjmehau+SxqptbmOViKppkLFUdvywO2/c" +
                                                   "kLYaorZVGkvjdCBnAYiKxK5Ji4KbV/iiWVi60GwjBjz3tUgbspYaioGVWmPk" +
                                                   "hsKVmstWMWKKQdStyNTbrg0gWqthcTi4HO7pM1BtmxnBqgOl7vWGbQx9vsut" +
                                                   "vW0Je89rDiRxmHJnW7bW3CoWohHJSlirtbI4et2uMnarICDUqOv25XmVlaWh" +
                                                   "BMUBA44pcmg3Yonz/CyhawdkhYKjpr4aKq1OztQUNCht5+rLJJzOY8E918es" +
                                                   "6hA1iBppfc4HscIWLC7y2iKbiumx2iK5as4NXjkZobBz5kJ9xoTdOS2z4dCd" +
                                                   "ybZMl1g2OypTAsKOJwNS4kWtH2BaXKfFHhoWhn7a03zTATmquxyUhXKMr9V5" +
                                                   "ALC5uuJP501QgH4UpclBSEkeLFahwM5PnX+cFYXgCLukSAq1sXczyCgjD9eT" +
                                                   "UM9F4cSV7O4csCtjFZ2avVrZCZ6tudqt0HoI2SUJxNPNTMIi4IRV2REvYrUp" +
                                                   "1/P+cFgUG9ozIrs8Gis8FhMdDajdaUTIqvaaDjozgdy6RjrD8lQwSoopCp5W" +
                                                   "AXtx0JzDMmen/Cbsq8xstrsZyCCcd/SHKb7cCHA/YKLJhFwZaJRMcFoBJW1c" +
                                                   "WJFqrSA34cF+YWXTQVtIYigSap4Ea7TQI7fnWEZww+0mPehlwgkNzWoH0Jsu" +
                                                   "EiEBwVnvQMdDrwipM8fLFRkussh3LLDndQLf1NtV6G1OfB06tSc5M7k9FpK7" +
                                                   "sCJNGBXEOFtW3Rc5j+/O1qYQQq1ZlYlbmsI6h8qD3gykKvcRcyRQS5nrCmdW" +
                                                   "4TbYdLNwv1iLxDqBlPNs6qj0EkC9smq0mcoYhFwrBSObUoLowWKVgaQKpiqK" +
                                                   "Wns6wbxD1oDmSlXxUmiPB57Kz/WKTw5hC6QG0uxms4M6xxante0u1kvV2bY7" +
                                                   "NQEqyCWg9rxjjvAalg5KWZoYvsZyNvLnMgKdQrQhtsV2e8hiqumio8xFeHlu" +
                                                   "OwA/cT4SKyxI7YNg6MRaT8HyCG4IJBDk07brV3vFigXDsmcQms4xB/dZ1HSi" +
                                                   "cBMJpM1suDPZjHGUbGO9RMJWck/oHGAbdA+3i5oX8wE7zwteWTWDwHCkiwMe" +
                                                   "CQy+5GYxrYKRhUyt9Yad6QINzNudvUohazWe5kzB0tMikMQpZebwYrqG3K5P" +
                                                   "xdVRWUWmESCDtu1E6CQppNOCEj/FK9HmWHZLFa3GDuWw5sVGS05buUtISD4C" +
                                                   "SHPqh6FRJc5OS61UZrNGbQxhM1uZ+lK2NKGfCtu+Uvh2OBxirfQGj93OBbx0" +
                                                   "GypELOEc1BYZiRodBdO1kdqV1YCU7zvr7WwdsipO5CXZdci8dNqB6jvag+bm" +
                                                   "nl6S1b5F3fCcdzqAUTYKGaYkJUtfOifiarpgDX047AJzAx712ckBmwOyjfLC" +
                                                   "1jx+Vhw3m8LAV73nrDTGUoVE0juN1OplceJbSNyIZNv2MoUfFDV1CYGhd4uZ" +
                                                   "HPY7WoigErKpPUQa2IJ34pUYbhRHgGdkjPVcr4mst83nfFcTfX2k7OZgFE0z" +
                                                   "c+Y8hNG1uM5wCOn5NML8BSdz4Bpb1K2VIGi5nSo4QcnbYm1ZoLreVcdUi+xV" +
                                                   "P60Bc75YNGcJmouaIQDOupVoigDxVVJsAiVS9zM6t1Riv9m60bxsVYLsYGAq" +
                                                   "AkA9o1gcr/dMf8CjgCByhThucxBdrtyCMoA9QM8KiAOzbLMA2TPsb+VTUTju" +
                                                   "SZR3FRKsiHja0DKOn3zihEADpinnOQFvWSLonCAhcpkqfVxxm1DHl1CMLPAR" +
                                                   "AFi2J9oDLTwco18eUBtHX9ew44rJWvXC/Z6nlMMZbNc2m+hzxdfMQ1ShdJh0" +
                                                   "wCYjEw9H1qu5VZDcgRJ2plSuXCatguVOx3TVlMipzuunE7YKwdlB821rABBh" +
                                                   "T6NE2oEszRkSRiz16rQl2lQyNgt46u+rSkFAXgyrk7zFnba2Not0c4Zmm9MZ" +
                                                   "nBEaz6xk/9yrQ7YvpcMi24MAvjiAObJCbbqdUqi0SHHH9V1piir7pRXgnDe3" +
                                                   "T8Q66pJQCYDDHqGWp7LP9k4GtxGN7beLUjhu16YyJAANnE+ELHCLbnaGhqW+" +
                                                   "nNW+2xEMTSf5aeoAuzij5GW0wDLCrXe1Boo0qdZNWxLUAhhThzqQB1Qh604J" +
                                                   "5W1uz/IjTyw2PW7s0dNxUSKnHnK21qiX5miDMzHMwWqtY4EgncLjUVIweS8p" +
                                                   "szg8uk5HlmI1rwyOC2rAp0C3YGPwxJNLSqJc/AzAc7GM5nmanmuF6XGx3oge" +
                                                   "DKslHjZFBxkOY3ukr3H+tD8oq9VwPuHwYb46MPsUWcYSd9AYMyXF/EQihso3" +
                                                   "Y0qWmLKsyUM6Ze3e5zZ0NdtxLicI6q6eDUcXPwW90JpFTKIUSuNn6IRWU3nq" +
                                                   "HzUSJKfGutk1/QmXV9yYXNrzgJrORA5b7Hfn3KZNuCe3Y5JbYyEbJO1eowSO" +
                                                   "L0xpBWuBRdbuWQv94bSKtzTvy5jhMqimBWA6JgSVKqICqvGDHrGEHxS51/hM" +
                                                   "q0f5Esrn9Uz2ETHxabFiTfAcnGFjruWNjtKbI2rWQACFPQJBm7ZYETs4BjbY" +
                                                   "ugfEk83Ou/kilePpAT0ZWC3xvb2EOulwOu83QrTrD3BNm9lB1LuaS7ByXzqj" +
                                                   "pSDL2eGQpIB8GLJNbfQBHB6kqcAg+RE4+j29mJ4zTB4EmaBStzoamKEgY6zW" +
                                                   "zfZ43laUSrH5JWWVrJJcAMSC9nzB3UvlyXEMX69ns4Gxlxpc7vsjXRMs7xFV" +
                                                   "ba2bA6O7e2zEcccuUbc1IWs656dFTaku6h89e0CRnbfDbXSW7zxnJ+6j2XpI" +
                                                   "EtFQBe0AjbkqPQfC7R46YHPvSB3EQ6eW3IZqD80a3yVTXZsK7ooUZbSm4mLe" +
                                                   "ibE1hROvE1lot0ytGXoggoXObXC0bGvsdKphdt2dZ+cV68+5OTSE4jbNqvQk" +
                                                   "HufkXMfTMTdSGtIdiVsQPd0DcgcjbUhUhcQlW9Mp51sEyIQE8iRYyIBZbSRM" +
                                                   "IR1oNAJMa3C1mtkOHb4466sBSxdIEkwPNkeOAJUAUIDRTg/G8tAdMzwQHVoR" +
                                                   "W4gCGh+xHGtI6ylTSmTZuLBZcXzMbs5shflRQdL10pPa/RLmmED28XXji+bS" +
                                                   "PTbGgWnbApQT9ECzwTAaxEZxI2RERVuxGgGf0xV15mcrjBD2lSQBa6rDqIXS" +
                                                   "t+fKnFncgY3ZZXjQgmxKuybWMbtlHTN+OCW6SkIO3ZokDLlx6JJHplg65s5M" +
                                                   "QOziTc1WY3J6JGua1Nep1s/EHlsOczg09piDrWt/6WyWZuQS+1PnbIZtOGxN" +
                                                   "f1sLRZbMHCwW6QBfEy6Bq5k0BSpK1rCBJlRscIN859YkuTVZcsNTRLSEtxAm" +
                                                   "HxmfVM1e4xyAjs5LeNeN7jaGgkb3mXLFEts1vTNXcU4yyJGforV16uEVoYyp" +
                                                   "y3rTerAcQJXjp4w4rSMnTiAbnQ6VuqwWFemtJfFIYzSwzuqDH1dbgZpCKDBm" +
                                                   "JqO2Lg9T+6jFY0pWG/HW7mFuKWPYdOUi3hIGTu1yu0V35gwOyG1gnruUw2ZL" +
                                                   "sTzIAXgEiIySEKZzKQzixUhzlPEMHCHz7VLUR5fQOB7HbTnZgQ87U6RkhB4Y" +
                                                   "XyXR3mtNQl+OP3P5gE537N6ycelMb85NivLzVGm4wWjMGWUb8iGzbMOI0C3O" +
                                                   "Knbl0/lJQFPXgBi0bwLRkjIFtFasEGHKQC/iiO9NH8+2caC7y3x7IEc3vx7w" +
                                                   "8Ty6nU2xIkp1J82Xx+kUsPFwjNVFnW4xiPWanm3g/VKSlTH/OEsDukvK0w7q" +
                                                   "VuMZZclR5+2ObQ8b0keSM+CUHM/uMXzaR4Ox30tRz2xOdAhBCGpQmE/JRiFB" +
                                                   "4YZE4jLeaZ0SDLC1w88oBmmSdKyOEahELFhsAM4AWTBK4HbFcRVtUoJ7Ag2e" +
                                                   "QbuzuzPprZ/GFksbzQmDxkhSIk4AOFzEdX5HQWp2Bjwmksh1DMgQcWaPYbQI" +
                                                   "92XM+oFMEMUKOW5cyYyZHZr5pOkeVUZmhGDfhcjK1VZSu9yIuGLW6sZsp5qz" +
                                                   "Uo6A6gAnDpN5oojllNT2m4gsQ/civzmrWCEUraptGhHS6gwuzBXcRPziAC9z" +
                                                   "eReNsHxbnfBdN547tbQSKzqqKWTKpRzabar9wJSmtyWiYC+DKwCU7TEx012N" +
                                                   "lxXCSjochpacyXUuDRIbOoBbMmGLtsaPEbQjMHPrlOU8kwCe3kAKJu6gvdsr" +
                                                   "QCPb9U7bkY5gW0t8kwlFwlTZmJwU0vYgwXWtRGZ/0gxx0G1n4AJW07M1uoMq" +
                                                   "gA4O+DSCk3xxpO3jrCyME4Qqw2K+O5z8uQGgrucl2Wbus2ATs2VCK1bT8WMe" +
                                                   "obOov9EMa+7PhRaMkBCY1hyNBMMgCDAeoAcmPqbwXGXwtXGyYpvuaPHE0TCO" +
                                                   "2eKK8nB0NZgWsY7laR324zHjNN22uN0oRhIODTQVt+IRoDNLihHMCMJ0uUIx" +
                                                   "nDr7Kg44BhuZiLbKVpDQsdvCL9lyCprpHrdLqwE25jEezxPHmU+5syxXDh0+" +
                                                   "VVcowvhOhPOztap0oM6Uuww0F0bqJDETjv6uOh/onWDjLL2h65mGFgWdFsfw" +
                                                   "zBvVUHdUiZbi/LB2vOlGrtp0czxY6p4kaa4EwoUQxPt8icEecXSiDdut50BG" +
                                                   "J1pTnE1lT0Bb2+KRfowznpDCPi8jci8vtDHfAJcaAtAmEpKkHvTcyDErn+Ka" +
                                                   "R6Eccxrzp5MuNrvymJaDVS3bMQCTAevFTpe3OnjkqGVgwsc9bBzmUKnQWYD5" +
                                                   "KTvmOGG9BbfgboaXRWGEmXq0sNYOAAsXlWXhHBncRxmm5UJmVce12NnkmJlB" +
                                                   "Z7YTl9b4Mxs90Hw2nrSsGRzzDLFcAVUJErgkIFTupytFT2abkqbWzTkkhjHL" +
                                                   "OIpZ2XSxRCBNAu3FeL1B1rljK3G8049caBIkM+1Ymj7ano0KJDitpzKEhL0K" +
                                                   "y1rqOWjJIriLiDJPpfBO7ppsFwrV/rwI");
    public static final String jlc$ClassType$jl$1 = ("STkv+joyT9RyicpwbteKC7WrCNnKgecjm8qB+6DPlu4AaIjBZKIL6OLqLNiM" +
                                                     "HVtx2nYc7qona4OctMUY5skUBhkxzBxhQJ2VK+0lwKs5ZeC4EQcLAT2ubfLj" +
                                                     "YluyMEfNDY0rV+u5cS4qZ1OWFYASewhaGQ6Iy8bURbrjFJYUUR3MuQgdFjN3" +
                                                     "32B5s7WnzDanYYSlTjwWIqh32M5UHEn3Wzv2uloVpii0h2w9a30e2O0PhMu4" +
                                                     "6/V5uTBjk0M9TpHmghHR8xrTWsUBjlNhxS40gEM2jKV11spbrsJFjQ77AmCY" +
                                                     "veS3R6NxtYGhW0Hp+bxBpFrM1i6WUl2zTfqwkUgEd7bUIA2gqWeOLszTiJTn" +
                                                     "HkTEGIaYugPrw1wewHOz6LimTDrX2KzrfAEZXb0ADqQ9OI1zTGfzxcpO95Yg" +
                                                     "zQmqVnEUiubtZjOHjzmSMcSC2MzPGseiQrNMOL3edwy1SJZ2GbGtwEX4IumT" +
                                                     "dt6zIHNQi2HEbTz0S+xh1iGOlMApT4ZdjB3EAiCQJUUCUbJCcCHrzziM83B6" +
                                                     "UtPGni0G6ACk/qk9gwOGwJd/z4CQbdjOXErOID+wWeo8qNC5Fji6YdeNwGZH" +
                                                     "Kjx5ZLBZ2yDaLgwahfBImAverp9tTIzZ9yuu9F0KsqO+J9cpmC3GiJPYRG7w" +
                                                     "ota1MJ2ClmCJ5O4glCoaN4rPlQSbDu6sKBEd9PYLYr5sp1tpPkXcspNnmwEJ" +
                                                     "LfYI67MZG3SIBRdGg88RaT+cMjNix6SwQ6b9igw1DxToTYycPDcbT2Xt7riy" +
                                                     "wuAwXWeZDuTYkpoPU26qnDeDg0TgQthJoe5UNk9Qa6ePTdHFjxazYgSkSWeL" +
                                                     "TJ0dwCEh0ZVRd840A5T+ZKKbCgU8KQ8MefQnGU7svKE3FHddECuDNTC8ys5l" +
                                                     "SOq8woCtiulL1e0SFBsO+22pkpxWpw4M1Ut1pmrWUm1iQ8Yc0TFVAVn2Fh3p" +
                                                     "OwFG8Mxxo721AWYcS2H7KbMYKhmmeFNHpJgWCo0jc4uzcgg6G6g4zi0cNTu2" +
                                                     "IsAsw9NsLWgne9QStGW6UtmCR3M1F6m1MDREiG6dQeHUmQx63S6wVD4SVXNv" +
                                                     "YzXjEUENZYN2kpVY3OXTjc5q3RjEwgDWRq9grjc75MDUsVWqIAJH+bg1ovdm" +
                                                     "jAukqcWWN9Ds2h3ynOxpby6zwLRbW/wsPSPUFO6peOhJhYJ3sKz4TTxreI4W" +
                                                     "aiMPVEyhMVHaDoolwGhzAkJX1li76KuTEIgINTtkqV+PJ1hYJXRK6bvUOQ2O" +
                                                     "xdXMDIOXtJAsWcMj8nbmcwhcjXkOC4qlh/dT97i2XfagHWZGhvfkoHgesjWa" +
                                                     "mZQWGeEs+EUlRUvQ8OW2tFb8QMgor6TKweSZxWkLOjpYJ0dOKNeHDZXwcrcy" +
                                                     "MrkTGTQBHPyEbfzc0jeSA4Ue66AnJV0DDG4gJ8ncbow9M5UWZLXNzNwXbW6X" +
                                                     "uiKSZUvAg6rz8UxDC4YHbGG+PYKyOawlgeal2N/Ki82KiH17JRMGS8SrMROF" +
                                                     "og6QlHBnK1P53HfheuiwpaG2JFmMSJKAI5325awy4gGHSYqYti6zXtHkKU7k" +
                                                     "gTMNCbC2bJPCqTMDI+/Y20pBNLlzNNGctswjma80ZXdm62ZksirBMx1q8SW7" +
                                                     "dDf6uY0bIs8XwkxRDLTlglJuQkg6gGzGizolnOeJjiutByDoYtEOiiiPx9hh" +
                                                     "mFa5Myu2NRQ2g03VKbgOs0ORlAiN9efTspx5sbZz5A2Tz+XV0KmEtzkBMi17" +
                                                     "umyK/JTCauK4mnd6INaYLANgZhpyKJPnveAnGLdcnjoQdeAF3zYRIU91Y4rJ" +
                                                     "DZKQ8ypbsRsG3ds1PPWTocpXp3bNyvr8LErdltkPcMKPHgTkWlfw5vFuivqq" +
                                                     "ts5Ddw2Xu3YuS0jsbCSAIMgGBoYdzQdCPc8Ir6uYaTss/NORpBbc0tbrgMOa" +
                                                     "AIjHrITf24zflpW5brSdUEzNeAXm2/WuCYkejkQPyvD5alkwrsRjCA6rOwVq" +
                                                     "YYmPCH2Y8tjMXQ10FJ38+BxE3sh1DJoHWyoveXDHbtZ8N3dMW4FmDCRmQWeL" +
                                                     "iQyjTDbH1jSzkIRcS2CYgxauVmmQk0fLKaHHGr7Mtb73TXiqQPHabGin44UC" +
                                                     "PRbZ+jBNbWXnUEtJgVPRo5eEsvHPwOE6tsmnrLXltoeWN1czYHWm5mm8SwsK" +
                                                     "gOtzBZ+4cnpeSg3jqHssNb1ktXEUqM7mlEYJIp6jAzWnWLjHYxOl16p8Ynwi" +
                                                     "LnMSDc9LZD0fdVdZFb2wOi0Dsky2DBeHXrLPrMP+rONYXkftslhiOeNmOatT" +
                                                     "UYbBji4lMp7Q4iIEXCgqqIXKELoeQGnjAap+MIgyOe4QYR7GVE6dDoEyHryy" +
                                                     "oCAWMLp3q6nuSK1AtYKAYJ1b12eU2yaWfDqPBpSPQalVZ9loOuQ4jCtGHBmq" +
                                                     "5nnQ6eKzTSoxwFaDulQ2O2wu7vjVUVznwblhmqCRfSkfqRtyCEvFhDnxIVYB" +
                                                     "MkrLLW/RW/G8b0EorXpLg7m5jXRrkXTpGo4DUcWhDGA7vNi38B6fwTusQ7bI" +
                                                     "mAVzm1YCwFnA9MeKtUkmKXy00eSq2FcOP5yjYk1BIF8l6JQia20jgvDZwAFy" +
                                                     "fegFh+/PdrQqrVAQjliS9QtUxR2uK5eUNTBkOpy3gdMBQ31WMi0LVLe2PbkN" +
                                                     "DnrpiduFGXaiJA0ZAAW6toGJEtxhVNcOJ2vdpT1d5jsMPwam4YS1BE53CKPJ" +
                                                     "cweZGV4joodsOdfgPhyETSf4vVmOwXMLOI7VAfzcr9WiO57DPewsizPsiRuM" +
                                                     "RnrWbwO9W55iujO35pioO14qM/wxG5PyIJUTqIh3QeUbEeUyZtBoUJbQpDxs" +
                                                     "fKypj+1Sv/wbipbVrL4h9kiHDUg/S2BJ7gcMYLZ8owdsNhxDXp8my81a5obc" +
                                                     "ZlKpK9dzraoVh1+DfB4Mgo3Qtoz6OEi5W4yifHLl5tBQb8ag1dLbaubONHft" +
                                                     "HwSgdNboVCHtqIDoXUeMcScJ7I6oSQIhbRH0mMGhUjJeAInogbJKp0EkIoS1" +
                                                     "V5kDszqCfurQcNLEDh9sNYY+K52Rb2kFWxbsFhitnipWtUUb6wuPCfNSCvCd" +
                                                     "t1UF77jWPNyvmj9G/mXiW59WOHDn10bfyJh1atHLFbcKBdSxdzxJbZnVmKZw" +
                                                     "gwDvEKCGt9ChLmolFjIQcNqaDsq9M0PnMlms091sbzKmvp7S1jUpZ2PwzI60" +
                                                     "q/mwLGl7L9PuilVNfSZTgqae47m+c9ZnZmn3dsMsu1YxT3uzr5qaFTzykDdR" +
                                                     "RtsMi1qeuhzg05pauUu4PHD2Ej3lmZ3tWRTFMyykXFwnTKaXJMeb54ctsK5D" +
                                                     "HIWFs+s0etxT++C4SqpIAiA7nRPyrmPy0xK0O7qeD8veIRaQu1iSJ90LCBS3" +
                                                     "yQoNvPG4GATkst+4ETHdxuFgZ35TKEizxICmxrfbmA0wFAul7RSznAA4Bo5T" +
                                                     "nxMRTALNExxcE+1jm2Id6h7G6J4vz1S7SzLO6/aw68YabCQSq41hqqujMVZY" +
                                                     "6zNMNQac+ji8TOO4Jvdyk+15RULxbii3EC+ljW/ukGq+Pkc8wNUFVAKdx8H8" +
                                                     "NretslxH46Fe6h0fOZxxu1h6WBrY+2oIfVYiV7Z41rYCtFULhTlZybAgQsnl" +
                                                     "UR6DPMxpp0oKmwSMHKfOGer6ON35hxIUfRpAxzw7hBFRrLkpUmjDSfP2cE16" +
                                                     "EWg6rpdjeL7ZQ5msOJEOaG6bBYp6LpRYEtGz3yokMrc7LokhPIM30noFzfy9" +
                                                     "V88pAVGrDub3qyPSnxwNQeATDiVTw6ydOaPN91Xl4C3fADR/Wu2s1q0YPQ1i" +
                                                     "eFRMPBe7TqwXeNX5HrA64qGZSOsMK9kdXfmOkdfHTbUAa07q68zfcmMiPEWZ" +
                                                     "3Xba7WVHQE6p4RAE8fGPX1T+z9wayBc/YSCvgK9jIjdVT3/uGVVrxCP1Rl9+" +
                                                     "2exatP14xf1r4gXkI9dP9A+qqL7yfhXV9e+l2xsM/+i2/7GHqqgeKgqeXCoz" +
                                                     "3/d6l02uVZmf+7bPfJ8r/gB457Y8jG4mb2ry4iOJd/KSh7Z66/U9uo/GW+5d" +
                                                     "qHj/ZPL8j932n3u4FOwBlx6j4IrZm2+X/LXb/nsfp+Dp1Wvf/4y5v3pp/lIz" +
                                                     "edeFsa88zthXHuATPVrQ9uHx+drJ5MWvvu1fegYVT6lmuyx58aZ/4Xdfn4rn" +
                                                     "HlQXf/111x98Bil/+9J8rpm8tS2CynK9a93kdenTxHB3fFajIrzntn/xCxPD" +
                                                     "ZckLN/0bvxACfuQZBPy9S/N3msnbQytzE++h8tmnFayd8sh9GmHT8fnGUUr/" +
                                                     "9rb/kS+MsMuSH77t//bvT7/+8TPmfuLS/INm8rbAax4j6PA07C81yf5k8kU/" +
                                                     "eNv/2S8M+8uST9/2n/oCxPKTzyDhpy/NPx3FciHBu+J/U4N4GZeeZhyXMvZ6" +
                                                     "Mnn5nTf92377CzOOy5Lfuu3/8++LiG+97vovn0HEz12an2kmX3qprR19WeSf" +
                                                     "/6+0XAXygfH57GTyxcht//4vTCCXJe+77b/096dOv/iMuX93af5NM3nnaNqX" +
                                                     "i0bEg9LXy8yPvZ5KfW4y+ZJP3/bNF0bBZUl926e/Pwp+9Rlz/+HS/FIz7uk1" +
                                                     "xBNXD55GxPUa3sXPPje5+bv2zeQXn7wfdfeD4q9++3f9gd6JetrduY+Cc+zD" +
                                                     "89lH5vCHPnq3bK06Ktu88T54c/Po7sUz3b0E6yg75bFHef5Dt9I++KG739SE" +
                                                     "Uf3q0wPOBz/0sU9+qCheXy7Xv5ce58Zl9teK4hl8/41nzP2XS/Mfm8m7Xw/p" +
                                                     "p4nljZfl73hSLD/8h08sN9diHpZL1FzkcPfrv0G9+zR2f92j7H7D09j9X5/J" +
                                                     "7t95xtz/uDS/1UzeeA+Xp7H3+vH3PcHe5/7JHzr23pTG371V/ttLN1c+37uq" +
                                                     "kPsf/Prr7YvL6DdZqf3Jayn7zdv9C2zXn9d14ofv3oJbJ+tx+JurBjfA+Tes" +
                                                     "RzFG/t0P5nej+x+7+zj2F1E/PnbXufvxux98AjL/2N2bixR3n7xhp1/uE3hl" +
                                                     "O2pTMrJWyz/ovPqMnPzDV1JGe77d0LeS2nvCup9+XeXSfMvtFcZHFenOA6hr" +
                                                     "wl9eoJ6bvL66PXeF/Z9jCvKoSC6j64eV7t7N03ffU7Z7A5fZ9/2/wPpNz8D6" +
                                                     "LZfmhWby/iuHrbp5OpuvOPVjcvL4xOV+5buf+G8Obi7jOz/0fS+/8Uu/T//5" +
                                                     "m3tN9y7Mv8RP3ui3SfLwjcGH3l8qKs+PruS9dHN/8MqS514ek9ELbpf3m9hY" +
                                                     "9v8HoZyQsWhBAAA=");
}
