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
    private Paper[] upgradePaper(final Paper paper) { try { if (paper == null) return null;
                                                            Author[] paperAuthors =
                                                              paper.getAuthors();
                                                            Author[] upgradedAuthors =
                                                              new Author[paperAuthors.
                                                                           length];
                                                            return null; }
                                                      catch (NullPointerException exc$0) {
                                                          throw new Error(exc$0);
                                                      } }
    
    public void handleSubmission(final Paper paper) { try { if (!this.allocationsVisible) {
                                                                this.submissions[this.
                                                                                   numSubmissions] =
                                                                  paper;
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
    public static final long jlc$SourceLastModified$jif = 1501546043032L;
    public static final String jlc$ClassType$jif = ("H4sIAAAAAAAAAMVcC3xUxbmf3Q0JCe8AIbwXCMpDE0FAMVCBQAQMJBKCGsF4" +
                                                    "snuSHNjs2ew5GxK9VLRSfLRUEXxUpY8LrVCU3l5ovVqtrwqtra2trY/+il7a" +
                                                    "WlRQsT6vj3a+b+a85syeLLS95vfLzNk58818873mPzPnnL3HSS8jTUav1VrK" +
                                                    "ze6UapQv1VrqlLShxuv0RPdKWtQU++hbv4jfcWnq5TDJbyS9NaMhaSgtag0p" +
                                                    "VDJmm57WzG6TDKxZq3QqFRlTS1TUaIZZWUP6xPSkYaYVLWkaHeSLJFRDBmq0" +
                                                    "REmammKq8eq03m6ScTUp2lFrQjcr1C6zIqWklfYKZKWiriqhGAZtKR9LrUZ6" +
                                                    "p9J6pxZX0yYZW0MZ57UTSrOaqKjj92rgV2VXmkSt5vn42OCwZTa67VMrtt1+" +
                                                    "+cAfRMiARjJAS9abiqnFqvSkSflpJH3b1fZmNW3Mj8fVeCMZlFTVeL2a1pSE" +
                                                    "diWtqCcbSbGhtSYVM5NWjRWqoSc6oWKxkUlRFqFPq7CG9GUiycRMPW0NJ79F" +
                                                    "UxNx61evloTSapikxBELG141lFNZFFFxqukWJaZaJHnrtGQcZCFQ2GMsu5BW" +
                                                    "oKQF7SrVl91VXlKhBaSYaS6hJFsr6s20lmylVXvpGRMEPCJro5WgCCW2TmlV" +
                                                    "m0xSKtarY7dorUIUBJCYZKhYDVuiWhohaMmln+PL52y5Krk4GUae42osAfz3" +
                                                    "pkRjBKIVaouaVpMxlRH2nVJzm1Ly8PVhQmjloUJlVudH/3Fi3hljHj3E6oyU" +
                                                    "1KltXqvGzKbYzub+z46qmjw7wkxQNzRQvmfkaPx1/E5lV4o6VondItwst24+" +
                                                    "uuKpSzfuUd8Ik6IlJD+mJzLt1I4GxfT2lJZQ0xeoSTUNLrKEFKrJeBXeX0IK" +
                                                    "6HWNllRZaW1Li6GaS0heAovydfxNRdRCmwARFdBrLdmiW9cpxWzD664UIaSA" +
                                                    "/pPR9L83/T/A82+Y5IqF561uMNR0NW3FWL1Qj2XaVerAqxuS2mqzTTU0Y3VM" +
                                                    "MdQmw8zENVqDWjSXOl42UYdcbaRj+GN1lX2zvtsw1fZyejf1/9BHF4xz4PpQ" +
                                                    "iKpglBgAEtR3FusJGiSaYtsyCxaduL/p6bDtEFxC1Fah9XKxdRIKYatDwGmY" +
                                                    "UqlK1lHnpkGv7+T6NUuvuH58hFpTan0eFShUHe8JrlVOBFiCwTBGzfC356eu" +
                                                    "2DJz5Jww6dVIg6SxUG1RMgmzrmqBnknSYDLELlqh0jiTxOgmjbAFqRjSmGSY" +
                                                    "LzaymEjJ0k4jQDaSmn6Z6IAyNgdsPvr+vts26I4rmqTMFyH8lODh40U1pPWY" +
                                                    "Gqcx02l+SlQ50PTwhrIwyaNhg47NpCODKDRG7MPj6ZVW1ISx9KLDa9HT7UoC" +
                                                    "bllSKTLb0vp6pwTtoz9eD6Ja6mP5Av2P3M7zTXB3cArSIcyeQO3CKDAqz61P" +
                                                    "3fPCM6+dHSZhJ4APcE2I9apZ6Qoa0NgADA+DHCtamVZVWu+Pd9Tduv345svQ" +
                                                    "hGiNCbIOyyCtosGCTotUzJsOdbz48uGdz4UdszPpnJlpTmixLnuQUE6K+OCu" +
                                                    "4/kXXYOkvZ3m8EODToIGPsquUdaQbNfjWoumNCdUsPNPBkycduDYloHMDhK0" +
                                                    "hEk1Tc7ouQGnfPgCsvHpyz8Yg82EYjDpOTJzqrFIOthpeX46rXQDH13X/Gb0" +
                                                    "nQeVe2hMpnHQ0K5UMbQRlAFBpZ2F45+KaYVwbzokUerO4k3a3UjHadF5KG7Q" +
                                                    "GKhoipW8M74iVb3wFdR3EYQJipW0GEVBo3w+V2XfBceDubvVqjzaV3mJcxtc" +
                                                    "ZpjIA+8/b000/k50/GXoJ33iqhFLaynLsGikLzK09lSCiluNo3tTjGHqS6n4" +
                                                    "bMCUVpJGgk4wLCSsxJuLulJpmK47lTTqCaUyoQuM1GajDnBYU+ycmzan9Qk3" +
                                                    "zgpzQfaHZFwXRYFxFqWiqVg0YYWX88CMsQ2rW0eYTtdNsXuG3v7j4u9tnc/m" +
                                                    "4rFeCl/tOWdVfblpxn/9Eo0eDGSMKK0VqkJjPBNnU+ydHS+pK2Z+9CZzUn19" +
                                                    "UsSPKQp9YlpKAQzJrwB6prEVGMc8ylWpzyx487O++s19xw/XzUNbdikAAIIP" +
                                                    "o3INu0QHaZV3rrD5KV+pp2yWmmKXl/x66qgfX3qDW0wCgav2lt13F7x1xkff" +
                                                    "xGHbZjBBMAObINAUIJ3N+MVY4VGQm0m3noYN/eNzhzoXv8nYFe1ARnH+9CGP" +
                                                    "HC0dfhXXLHS4kPcK2WKpsi+myxBH2dHymsd/UrDi5y5lowapCNZjRaZPSOc7" +
                                                    "ClhOG54ok+cC3TT1dpdU5054aW3lp8/utxxgkS2Vyd4BCpTuYeZPeWj4lj9s" +
                                                    "rLXaWMKGWusa6kWsaEaqCyN0A/6aY0BkENDHYsVoo7PHC4nnG7f/ccoYJmzX" +
                                                    "7MLvP7hw0/bbHvjRDAZQ+tJYN/D8eYSwoAeNn59CXhoZKykPG8LPZaxqE1NQ" +
                                                    "ylaO9yfLSzGwwkpzlAcMVcPSxwEAsSvnvrr1sw4KACKNpH+bYixJ0gkTVlp0" +
                                                    "QQfR0/5lkkEut8KwBDAg4YY04vJA6KyxYu/dI6q+8AZ6rIM2gHpslx82rlJc" +
                                                    "QGj6nvb3wuPzfxomBRSvIQqjq9pVSiIDc3gjXaQZVbywhvTz3PcuuNjqotJG" +
                                                    "U6NEpOPqVsQ5Dlyl11AbrosEaAP/ZCq7CC/i+VQ3tAkRvFiHJOMxnQjJJNRZ" +
                                                    "GC4nm7RnLakkBDQxkLc3hedjXO2apFBPtypJjeJ8wzOXYShX42wBtuvevfdX" +
                                                    "9t29Cz21EPVHtWnyeas3UFi/2dD6eYcW5V2fJxsa8x6bYISMYIabALMMdzNI" +
                                                    "L5Y6id3iSCgcy1uazfOZInDspuMvk8ZpsFtXWBmltWd2vvvzOjTJfrjpYSnf" +
                                                    "JMNFg3fQNYYgL1OjODOzZEwZvukVG3RHpxdqPt0x9/ePHLCn1+ECCnCcYdbP" +
                                                    "9kR+tWr1PUyFLtjunvlg5ePaOuB7FmOyjYltWeDA2uyBjYGBTeZL1cd4/kP3" +
                                                    "wAiz5evkthzhtpxv4BYP/NK5Rf+d/oXo/2fwD91AAeTUXav4qjxqL8tTdHkY" +
                                                    "qjX8IYbqsp3GqE6+A6Fev+3Gv5dv2RZ2bdNM8O2UuGlc4+4HyQ2gq3FBvSBF" +
                                                    "9V/3bXjo3g2bWdwv9m46LEpm2u/7/ae/KL/jlZ9J1rmFtj1ai5xRWVSNXY3/" +
                                                    "U8HmJUeX7sIYPRDiHKIEGujAd7FoSdJb1EczbCPHod0MyVZYHeO84lWw6E7n" +
                                                    "+jzamoAg6cQG73Cmzk7vnOUvGmqS/ri0r7XCE46buHxftTkC7ydn0v+hlJM9" +
                                                    "PL9BEj6/ITc5uhAroPKlmEsVYmcf3tj1PL/GEzuLlURCj+H+orFKMzQLhKW9" +
                                                    "nA3nxLfJOBOi32AZwc2+6Hdv7tFvCBSW8pa28/wWMfrtxfpXeamG8tpbZVRY" +
                                                    "9WqXJzsWMkzW5bZAC9mNXOx3zGG330K8RV/hngfZ16gCm3U9oSpJl5ncKzOT" +
                                                    "iYy/8G95/qDETH7MzASSb/vtAaj+h+c/8NhDf+rD9Znmds0wwCRktjCUEz4h" +
                                                    "616whQEygod9tvBE7rYAUABVCy09zvNHRFs4KNgCUnG9hn8iowqwhcGyLh8L" +
                                                    "tIUnkYtfOYp/0m8LTwbZQoSu4F128ITMDmYwE40Usjz8vxI7eD7QDoDqFZ6/" +
                                                    "6LGDPkawEZzOqT6R9S0YwTgZwfs+IzicuxGMh8LTeEsf8/wD0QiOCEaAVBN4" +
                                                    "7Q9lVAFGMFHW5f8FGsHLyMXrjsZf9huBU5QmI5zpEEE9bj+xCf7g2aXbN9/6" +
                                                    "wTAKfRpJAQf9CP+X60n8ITnbcNG/vfflN37Tb/T9uJOT16wYDMOLh0L+Mx/P" +
                                                    "UQ6Op6/XEMZZ+sxqCILljOUV383BcobLCN70Wc57uVsOQvMxvKW/8fwt0XI+" +
                                                    "EiwHqUby2m/LqAIsZ7Ssy3cCLed94ILvF9ayAp/lvO+yHO+xKo3fhuk62Lpk" +
                                                    "0qrHrhtu3MRA22TbStQusxyxPycV6V58ITK9j1n2NcTbttH0pqtDA2qaJJr9" +
                                                    "SBXbYviyjy0JPAoqpv/59P8KnjeYpOFfeUxTp6TUND//+fc0jMoptDAe7suW" +
                                                    "4008rvFpoik2aPZdzS3XzjuIoHgACg8Raz0T42ne5QsnKqv31vOeMUt11xQ7" +
                                                    "uu+rh8a9vmowHh5aanKfECxTUpXiiQDs2dDyXgUvPfZEyRXPRki4mhQldCVe" +
                                                    "reDhCik029Kq0aYn4l0p7lih9bAmChMLW1/jnS3LuHLTPFdAZH3A3EN9+eIp" +
                                                    "VBK0eILkekh0tKEb6Iw0Hx8CQIHIZkx7TybEVu63wuVoEiJCTAH7Q2QHbnic" +
                                                    "538VY0pobO4xBUc8jLd0jOdHhZgSmiDEFBtVQO3XZFS+mLLQJi6RdfmGj3ix" +
                                                    "E1NCUeRiqh1AaIEYU5yiri7vVkJ2s5xWGVv+uD57Mtp2vtmmGWVn4QGLxKQr" +
                                                    "mWgHYycVaEV5tgVhcHmH45bQDLlxhG3jsO0iP6EmW022eE+zNmTHKispZ/xY" +
                                                    "47b3h6y49uIPGzCuhWOIs8bWkN4tmURiub1ihfQc1p5J5mEjUb0lSsNG1Eip" +
                                                    "MU1JRK1t6+h4GPf4qJaMYhy47KraI1/eumENZkdu3LXhsjUpe8vX3gqpUpJJ" +
                                                    "3fSdN+THtAPHK1o+tbZr5zL9vMWHZg/zXbz7HsYiSM7GzRbpqdii9pSJ51hX" +
                                                    "PjBs/5zv7jiMmy0+LYjzyDKc+p39l3O+tbBs1OMdW/51h8fwc6T8nHisAGZE" +
                                                    "ZnYv2/uzC06LbQ2TiL2p6XsyxUtU6d3KLGK9rvRsaI5hYgaBfsGBzqehreFv" +
                                                    "6QlfaEnAvQshqaYBKpbQk2rPykylUqEQIb62WBxjW/Shuh7DE+6ah+pZ4Mi2" +
                                                    "a87CA6t6CYsD2fbiIW3ogo2G0mxGDlWeQ9ExJz4P24WDj9ACEoK7fDlzWLac" +
                                                    "OYthrEgnz1e4wxkPC5cHLmeA6iKeL3VR08nDtc0hgNICKw7DhLaL53eY5NyK" +
                                                    "Nr1drVirxivW6+l1FRDQ4tSH8CKhNZ9JgQFe47zK51COO06ZlisZhtrEFN3a" +
                                                    "o6JZZUjXOpG8yR/cm3w4k5PpuZOF8iGJI5lpIaCBEDXcSAJrDsB0CGc2gngB" +
                                                    "Q7iAF3AvbiKX+w95vg9oVRRAi4UXurPgBfsRBHvDVThFOIU911U2wghtxMGO" +
                                                    "giQDyRgBT8AGOC4tweraeN7stl3k/rrc8QQuGMbxllp5HnO3CA1eL+AJe5kB" +
                                                    "teMyqgA8EZV12eIjduOJTcjFzY6hbPLbjrfI0TnsCKHgQNf38fw7Ep1vz44R" +
                                                    "QxsggedKQlcjKxup3jDWfimrrnBLcAQf3hU8b/Tp6uu56wpHMpy31MTzy0Rd" +
                                                    "7RB0hVQlvPZqGVWArkplXV4eqKu7kIvvOIq5y6+ru1zYD36fBcn6Djtoh1q7" +
                                                    "XBOizQ3+5XMV7rDCp4sbrFnqPPAyOtsTmLjrv/PabTvitbumWejnZpOuPvTU" +
                                                    "mQm1k8N+1lQB8ljlnUEmETy26RVmed6rgh7IwMDpA0j+wvPD4gicud0NWp1p" +
                                                    "BI6LSDlnoDfPIx6teHZ4GCqdn27loPTefj99+nhp9SHcoQnHNHhsx/fAW1zN" +
                                                    "hmUyKToluzFVuFODq7U2jg09SHHsGmiyXU+n2jT+4AxgWvYcW1RJt+L6OJqC" +
                                                    "+R1usM2faCbVmlbiKk770UnN0IsajyrNeqcabe6OXnXkxp0ABSazwD+HZVWQ" +
                                                    "7Gdih8sDQWJk/CHdQ+wa0kfQ7n7y+bbnP6FvSK5L6uuTbJOkvs/ezJcePvMF" +
                                                    "y2D5aRr294sAVPhrSP7bJH3dwoWyZ2TQT/IgCueCm8+QimP31H545PsWG+ew" +
                                                    "0aU8KvmtUEjnSVS1ECXRlOdwEy6RmbJJBlkPYFGjiaJFsFDCemKg5KUu56Ea" +
                                                    "+sODQP1Fy1gRpEecqPSSP1A5ReJTHjUU4iWcJcLKrxx8ftadR7fi0jT4kQ2B" +
                                                    "MrEzcbDm3e5nLGm2sX45CH1NPikhwLWXpY5kGWbC5UXoeIe1PyHgI9d+Soe9" +
                                                    "N+KoBI1hJlfFAJ4XulWCnL2d+8QFaBtPEKCl/jwvEgJm6F1h4kKqabx2HxmV" +
                                                    "b+JyNkLPlnXZz0fsBqgnkItPHOWf8NvDCdnE9abP92kSDqP/S8UDdx6F5Bgk" +
                                                    "L6KeUWN452B2Tw73Qk+G5FlhTsBJaSSfUd6TTUrZIhSkP7eMyGEIW4bFY7jA" +
                                                    "WTxa1zOYmdH1meObaaU7Chu3LNb7XbSoyyXIIr9si/wqQUMOD8mNDH7Aghae" +
                                                    "ZvdHNZtrFoYr/fztd4eQ/f4Qst8fQrCt8DiHmf1+/va7+IMNaFHOjuIfD1D8" +
                                                    "JFHxjjKy6fSnuesU0r6fm/xmnZT88nFMp8sE+ECAAOeevAAflXT2L5QgkCyU" +
                                                    "SBHKq09NkheehCQZMLHjB74uEGWTccF2nm/sIFlBrQPL7YfwgeRqnne7SLOg" +
                                                    "nQ5PAINDW3Iep97H87vdDDBd2QQzZAS73QQmaT4lDNqmJOMJ1Xk0QYZDrZ0o" +
                                                    "PxANX2QDvfCKoKFDhYsdCwxfijpsBObDl32u7UHVZ5C6LcCl1kJSZ5KBoryw" +
                                                    "tnBkktepa/EsO40IFilbfgTpLvQiSDZAHNtJPNsIsIbM5rZyP8/3CFYe7hKQ" +
                                                    "CFLN4rW/J6MKQCLnyrq8z0fsmva44jbanksLRGf2FoX+6nWjebybAzI3Ysgy" +
                                                    "vIm5MqY5IEvLvFDg0GWhz9AguQmNTaoKuLMakhusNsKbsCG8EwswtC1oaJCs" +
                                                    "gyRBskVXWwoQyPAJChj9XVZUc0sBZXBz7paDD5ZM5C19nee3iZazTbAcpBrP" +
                                                    "a98uowqwnDJZl3cGWs4tyMXdjpnc4recW7IBEp9OLg/QyX/2rBOUcIc4a/t6" +
                                                    "aQjo5bsn04tsRoOaDfS6keezBI31MKMByUyeV7hIA1i+P+De9yHZbZL+raqZ" +
                                                    "/ck3eyqGXi+UMS5Y+wgZwSKfte/P3drtZ8ChpaU8rxat/QHB2u2HtKH2BTKq" +
                                                    "AGsfI+tySaC1H0AuHnVM+4Df2r1Fb3mFPMKSVVYho1885Vn0QAmsJMOHepSn" +
                                                    "Q/C0A8NOZunz69zIOnICnuE9DvD8fS68M4Lwi1iwkBXgtQuMCkXLHLLDjhL2" +
                                                    "+PWyxxOFZK4LkW8NXdieyfPBJ+e6QFLM877ZXVcORs+AVs7n1Bfw3PNWBZv9" +
                                                    "bILZMoL5boJTBaMQKlSME8sz8NGGkwSjf3bA3l+Chg4VXneBx2Oow+MYON78" +
                                                    "XNvrsMHoxwGh9VNI/kTBqCgvWXAdwhU0SmZaQnDtLyMocRNAFgnlHlzxQeXB" +
                                                    "vKWRPB8mWHeklxBckWogr10qowoIrsWyLkf4iF0BKBJGLvrZHhsJ+5zYKYL0" +
                                                    "uUB0/2cZuv9zELo/xgRbmrtgYTFIvsBHV83zBaJgRwqCRapKXrtKRhUg2Lmy" +
                                                    "Lhf5iN2zFnpCZIITCo/5o6OnyIXuMS4t4t0sk8Ulhu4jk1hsxDRndP86clba" +
                                                    "4UX33HPhVjl6r1QVcAf2RSJnWG1EcM+KYbz3s3tuZBp6LiSf2axE2K0Qs6se" +
                                                    "4T4+MD2Vi+Nsa97w+eiM3E0J1g5kCm9pOs/LRVM6VzAlpDqd166QUQWY0mRZ" +
                                                    "l9MCfXQmcjHPcciZfh+d6ZloXXDfp6QTAUq64BSUhCLnvTr439ft0YBua/6p" +
                                                    "bgVUYb/3pBLSbwjL+/5N0GkP57ZA8g7P3c9A5oQqcMfqAs5AOc9Hihp2oYr5" +
                                                    "MoJJbgKTaKeEKuAhNoXOki3d/wS4iNTZk3fkoh7AQGSVAwYil6CSLkWnbPxc" +
                                                    "2+uwwEWkNcAM4Xg7UmuSYVnEJujZfnUJrOQTmaEJ8WuAjMD31kqkPff4Zb+6" +
                                                    "BC19zHPxrZVIhxC/7FeXoPaHMqqA+DVY1mXgWyuRJHLR7QSrpD9+JXPGGFTd" +
                                                    "fozhLvRhDGo4KNiTeGBqARRWc1e0gslkUbCbBcEiVRWvPUVGFSDYRbIuzwgU" +
                                                    "LHOIrzlSvMQv2EuyYAyMUst4NzNkUYpjjG2ngDGo26LAOzwYw3JgSL6OTpwN" +
                                                    "Y+CTS5E7rDYi2zqseSTSHODA96ADQ7LWYQXf2420i3blPIzheoQGXgiosp8t" +
                                                    "borVvPe7ks5J+lPs0yj228bYiPglJnjoirRxQdbyvMqnP3msc2yoBZpp5eTL" +
                                                    "eb7Mb0PZREeuw/HuFIMPWBSel0N7I6zp0Rd8dufuIzBTkem8peE8Hyr6yH3C" +
                                                    "+JCqgtcukVEF+Mg0WZelgT6CuxSRA45D");
    public static final String jlc$ClassType$jif$1 = ("+HcphCJHZqBF2DHCbubwfJZPZg/mLrM6KFzJW6rk+TmizB4RZIZUF/Ha58qo" +
                                                      "AmRWL+vyvECZPYRcPOUI6CG/zOwiN9YUnXVNgLP+8hScFW5+E5JvZ3EmuLcL" +
                                                      "2/gNprtRPx5gKvK4MoDH3/17eXzJxSODM7bWcAMDjhS+TK3pA56/IhhKD3tj" +
                                                      "QPIyz93v4gYM+JWAe0cg+YNJiqkkAXjOdx6A78jtvAZfly3jHH1kDc7nT3/p" +
                                                      "0Z+g1qvI1GuORb7qN9JX/bbNyN7MjQzSrLuWtxJSfCvP3efgOWgGSLp4ns5N" +
                                                      "Mx8G3AP4FfmbSYYaqjnf9/WFHJWDq+vTOVPbrfH5lPNpTsr5DPjKc143pQU+" +
                                                      "KX/mVw4jy8+NDJUDX24TP3QJj/GV+r6dy773Grt/x4Dew3Y0PM/eW7a+yVrI" +
                                                      "X9Zyf5fIdZ2fSqstGiq2kE37+IJLXj+T5MHLmnDdn/GIby/AO1PwkaRy9pGk" +
                                                      "LhYlSqUTvn3sDI/rPcPzX7rl3uOEn9008oZ5P2AE72Bl2MeJm2JvT5+28JFD" +
                                                      "px3k3zfL+iaoQ7Fvx9LlV52YxT551Isukq68EjrtXUMK2FKUIyP3h1/E1qy2" +
                                                      "8hdP/rj/9wsner7EV+xynlK3nZY6oPM65yNA7q/Zub+e3BRbRzbc9OTm4mvw" +
                                                      "9fZCzViZzlDTiMNXfqynw6Gta7G/c9grUHljacOni595czXrfqkutPbO2pqC" +
                                                      "v19iv1Qn1Q97Rekf8ZpOyataAAA=");
    
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
    public static final long jlc$SourceLastModified$jl = 1501546043032L;
    public static final String jlc$ClassType$jl = ("H4sIAAAAAAAAAM28a8w0WXoQ1vPt7Mxexnszay+2d/2xHptZanfqXt3txZGr" +
                                                   "q7rr3l3Vdemu8q6Hquqqrvu9qqvKrGMQ2A4oDsJrcASYKHKk4CxGseJEJCJy" +
                                                   "IiVgGUWJg5KsIrCDCCGyHQFRIIpISHW/73edbz6YHyBeqc45fc5zznnu53mk" +
                                                   "c95v/M7sg3U1e1jkyXBO8ubtZii8+m3ZrmrvRCV2XWtTxzvuzwDg1//0D3/i" +
                                                   "lz4w+7g1+3iYqY3dhC6VZ43XN9bsjdRLHa+qydPJO1mzT2aed1K9KrSTcJwA" +
                                                   "88yafaoOz5ndtJVX7706T7or4KfqtvCq256POsXZG26e1U3Vuk1e1c3sE2Jk" +
                                                   "dzbYNmECimHdfFmcveaHXnKqy9mPzl4RZx/0E/s8AX6b+IgK8LYiuLn2T+Af" +
                                                   "CSc0K992vUdTXo3D7NTMvvv5GY8pflOYAKapr6deE+SPt3o1s6eO2afuUErs" +
                                                   "7AyqTRVm5wn0g3k77dLMvuM9F52APlTYbmyfvXea2Weeh5PvhiaoD9/Ycp3S" +
                                                   "zD79PNhtpb6afcdzMntKWr+z/f0/9SMZmz244Xzy3OSK/wenSZ97btLe873K" +
                                                   "y1zvbuIbv0/8U/a3/ZWffDCbTcCffg74DuY/+YP/4Ae/+Llf+Wt3MN/5Apid" +
                                                   "E3lu8477887H/rvvor6w/MAVjQ8VeR1eVeEZym9Sle9HvtwXky5+2+MVr4Nv" +
                                                   "Pxr8lf1/bf7YL3i/9WD2EW72mpsnbTpp1SfdPC3CxKsYL/Mqu/FO3OzDXnai" +
                                                   "buPc7PWpLYaZd9e78/3aa7jZq8mt67X89ntikT8tcWXRq1M7zPz8Ubuwm+DW" +
                                                   "7ovZbPb69M0+O30fmr5fvq//fDP7A/T3f0WvvWozrVJ/hc7dNvWypv6KnoVf" +
                                                   "aQKvDuuvuHbtvVM37SmcICb9vuf6rflOFPpfqSv39uMr1ONBdagbL317Gi3+" +
                                                   "JezRX+n8lssrr0wi+K7n3UEy2Q6bJyevesf9erta/4NffOfXHjw2iHsOTbp6" +
                                                   "Xf3t51efvfLKbdXfdTWaO6FOIoknU5+s+Y0vqF/l/8BPfv4DkzYVl1cnhl5B" +
                                                   "33xet594BG5q2dPa77gf/4m/94/+0p/6Wv5Ey5vZm+8yvnfPvBrP55+nsMpd" +
                                                   "7zQ5pyfL/76H9i+/81e+9uaDqyZ8eKKssSetmQz8c8/v8YwRffmRQ7py5YE4" +
                                                   "+6ifV6mdXIceeZGPNEGVX5703Fj/0Vv7Y/90+ntl+v6/63fVt2vHtZ68DnWv" +
                                                   "6w8fK3szy3d/+8f/5Pf/i1aO74dh9IsI9CUEK+705CrO51h487Y/oBZ/7n/6" +
                                                   "b/539MGV9EeO+eNPeXDVa778lDO4LvbGzew/+UQ7tMrzJri/+bPyT//M7/zE" +
                                                   "D91UY4L4nhdt+Oa1vDLGnhiSV3/0r5Xf/I2/9fN/48ETdWpmrxWtk4TuDfPv" +
                                                   "mhb6vidbTX4imXzVhEn9pp6l+Sn0Q9tJvKtq/pOPfy/8y7/9U5+4069k6rmT" +
                                                   "VjX74j97gSf9v3s1+7Ff++F//LnbMq+413PqCTuegN05v299sjJZVfZwxaP/" +
                                                   "Q7/+2X/7r9p/bnKjk+uqw9G7eaNX7q3litSnJu2YxPT29USadDnM3LCwkxvB" +
                                                   "X7wB/N5bCVwV6TZtdhuDrsV39rexT9/6P1K/+4zYXA/bJ3Zhgd/4s99B/Wu/" +
                                                   "daPniV1c1/iO/t2+w7CfMlnkF9L/68HnX/uvHsxet2afuJ3zdtYYdtJeBW5N" +
                                                   "J3VN3XeKs295ZvzZU/fuiPnyY7v/rudt8qltn7fIJz5ral+hr+3XnzbCiRGf" +
                                                   "vDIJuGs8WN/XwHX0E8W1/GT/yuzWIG5TvvtWfv5afO+dXK7N77tTuWb24bw6" +
                                                   "21k4megjcX3s5ip3j7rvjOpaIo9ReOOKwpem79PT1r9wX/8bL0DhB94DhWb2" +
                                                   "elGF3eQo+seL3oT/0fvFfvK+/kNPLTrx2U6S3L2FbbUR1uGkzS/QiknL0smE" +
                                                   "u/vIwfvJr/+xf/r2T339wVPh1fe8K8J5es5diHXj0EdubOqnXX7Py3a5zdj8" +
                                                   "b3/pa//Zv/+1n7gLPz71bLCwztr0L/4P/+9ff/tnf/NXX3A+ve7keeLZ2Xty" +
                                                   "+3un79snhvz39/V/+gJuC3fcvhY/+G62Xmf95fv6l55h68cm3NTWScO6vnL2" +
                                                   "NpW+J/xaMc3sA1Og+p64YdP3mdnsAx++qx/8Ly/ATX0pbtdZv3lff/MZ3D5a" +
                                                   "P4XYu0PLmyu6k/Pf/8Zv/Navf8tnf/F2Kr7qTKfKzXqej8nfHXI/E0nfpP7h" +
                                                   "Z+n7vfeY/ZMX0ffIbD5yMxvZLu4tCXjOESLXwnrEjh9+sWE8uNlmM3mFMLv3" +
                                                   "kpONvpZ42fku3JOvhdk/3uHB3bRHSNw56ZuvpZI8867+/tHYXZAT5m8/Tn+m" +
                                                   "wf5duFaz736Ox9KNPU9c5V+QvvGrzPe5f/LB7AOPvdy78pVnJ335Wd/2kcqb" +
                                                   "0q1Me8bD/e47Bt0IvBa/5yXHQ/qSsVuIHE88dK8ceET9J55w5s5D9++pztD0" +
                                                   "feekzt19vX+BOtcvVefrLOW+5p9V56c82BPUpvPx5iRYuw4ku3gKszsrfGVy" +
                                                   "mB9E38beRq+/xxfrzgfudee1+pYBX3/ZjzTo26PEffNRkGZMGjrt/+a07Qu4" +
                                                   "c5c1vgCFSTM+9gRMzKfU8o//nT/x1/+t7/mNyZ/xsw9217NwcnxPrbVtr7n3" +
                                                   "j3/jZz770a//5h+/RT6Tin31z3zO+Nnrqn/4WvzBKS+9YqfmbeV6ol030i1U" +
                                                   "8U6PEXzOF706yfVFCDYPZyxWc+SjP8lwKbTXeyf1UQXiKW9Bcs7lSEkFvYY2" +
                                                   "0zC1UkhF4lcCxdQbrM5ald1GNeJdcKYXloa4V31xr6+PvV6YC7EyKB1N8Lwz" +
                                                   "yqa6TJ+NNJUJAmEytw/JXqk1ootQG3AAe4HXgyeK6hLvfHHcxvhiAS8WczSV" +
                                                   "RznLRJRV1UWk6XYHG5UweoRuF8q1XSaiGvRtB+3lk3BoFB0AAqfDIt89ZCWu" +
                                                   "0bwzqMutLQW2em7sM1QYNJ+m+PwwMoRGC71Vokq52SeaCk+rc5Z10GWil9XY" +
                                                   "tE1DPMQ266kiv9nTq7SE9uvUTlOhXHglhKaE6mp6gSSbSoncCqaIkSsPceKb" +
                                                   "giUcwiosA4a0GmG/FCvdIoolTxS9dYQG0zpAkoXPdU2tdnYpRNESqc4GYhzT" +
                                                   "WG3wLsOQHXWxNJuYG1LVNDAAuKS/l0JyH/GkurSdsMw2ZafGqp8UPIs6sG+l" +
                                                   "2wMqRQvf8CjJSjaa4YmIDRfq+hQempJyHdVhgkY1DQnfHqL9ocxVl8gPQh/r" +
                                                   "yX5TbuRyTjFLRg8Hdy/JB2jLz5cbvd/2BOx1Sa6pdhHG/WotMjAGJ5uttdls" +
                                                   "+rKND7xt2TybVQ2juBa1URBGqlt8dcgFZTNXKyNZwsYxEYKVrZq2SgT8pq6I" +
                                                   "GoGSdEiMY1cwe2ktU3yV44czRR0QLU2MFOpVobErc37KK53TVzxlWkJg0kYb" +
                                                   "HoI8sKU0yQBZxJEBF6oYY3Tbw5C8Jv0RLeJ9tBI4w85b2yikPtmzSGbwYwqL" +
                                                   "w0I2AiWNklznE6M9sSC6CdEgidgIXRP5oMNC0hzLjhkFxxxbBxgxokyjy/wS" +
                                                   "98p23Ctd6se23MPgGk8MLCeMPDtxzaVuEAxoW6FQR7/VTwsuJriEp4GUH8UG" +
                                                   "5jCm9zUk4S0F6r1c1fStWAnrjVDx3uroHSFOINjDNkn2ln2AxZBgbBUKPDLv" +
                                                   "hpPfb/enPZVeyP3mtKrEUxoelm7RH0aaIDCds1USLORJwxYoqIHkAgFMnCs3" +
                                                   "OAG30nYPTTqxOYiwEiFHe3JhZNm3KpKWo6bpkIkaknRS0stiXG+Nkj5E6nGX" +
                                                   "YIhunlzH3kcAs4WTIzJ2TX2Z9GvwIh8Glyt2g/UjJhdKKBTnZHUm180e3bQ1" +
                                                   "z4SqbTb1QPX2qRXBgnDoZr3pKXhjB8uj0J/2nGDaDX1hUlMvEwFO2KyImW4O" +
                                                   "aMRWb7uWxRfBptDsDPI2aqCz3oKvEmO32oTURVsxo0+hOOG1CM2POH+5ECeD" +
                                                   "OxNqrzPwXjqnY5WWqyzOVJMW12JSBlAUav3unEYOuSn3kZoyqimO9pCuIx6K" +
                                                   "sUihbTXNCIvgyGF7PtVyVwETrQjBYdNSmrQZ2EWyowMM0uFCPphM6fYQkgBq" +
                                                   "ouCQrF2CirsM9jY4Y/NtQe1ogd4zc0mOCMs4wJzaLwWRtpesNtdzykkSVdBE" +
                                                   "B+oKorhoTT4uPZrgbSKVcbJDZFSaj9pxhbpkpXLu4Ck7lBJoshwJWEZ9mZII" +
                                                   "4MSqVsBjpOyuEW5pFxah5Da0PZM0CdAs1dipMW3cAvJpqZ3aDsXwulMCJtxS" +
                                                   "DrcbBqrJa4bS8kYf+Xp3ckZs0TKnEdNP9SgXGZ8UWhr2YtYq+poQgB3VYmB8" +
                                                   "PJq7uLPQdLHe0VrOMXJdTvptK87Wjw55m26pk17LW3kVD+6ppc0kZyU6EKBg" +
                                                   "HcOaO89bhcl8+UzVHVsM48I8L5C1GdHFTuPHstpwuyYovCNGVEeFZmH0CDIO" +
                                                   "lCme4SGBVGSsAgm4LjnKPiE3q8JCNhgOCJNbvjhjHutetcNi1Eb1iLVPG1xg" +
                                                   "5gojBHlYHBbSHAsNB71sTnt0bSr81Acxa2OVoxfAQI7+yvXo1plOpWi0DTTl" +
                                                   "3b5xrSLiSGABOhAEgTEOgcwx51F08uIb0R4ysWbCWBwFaJmoVJi02xxttIhh" +
                                                   "S5XIMEeidKPgmXOMXURKrXu+FduEL1IBmyeaVlK2PuRKK8GMHdHZytSBwU1H" +
                                                   "O1sqMTqei1HxbdbaXI57c9NvykNYGmfINA/HxYKSagWpDpBnas1pWx9bBu3m" +
                                                   "EdYum8wFU6zaeFQCNrvDyfCdpOgzcLnOIY9mVEkQIKOM+UhebbNpv0l/gEJA" +
                                                   "LGBJWaOewUu9VmVBKZZmUgikMvLVZUUU1dpgJHcxJIdiHHpsMd8BQA0v+wt4" +
                                                   "HPWtcwpjkuQ4OUe5bQsprG0ZaFXRuGAARYEMh+lsPCZgTxDl2T+ik0+BLtTZ" +
                                                   "7pCkgdHNvIf72Pd7hnWsaLWSyJ3DbUmd49EtIBkmZjBKCqVolptb0NuOwZgf" +
                                                   "u0VmbjyY3GfshDcjsxR08oPjUWRVLJZdATkIRR0C6dCvWOTEDml9AvWKDvEB" +
                                                   "T/KLXVBbK9rblqzu3DmVBDsGx/IYmEIcTYNPxUnHIRyzD2hSLMC26ftzrCLG" +
                                                   "cMJWVKG1pmfJ3iHCkmhZV+LRPkgCc2hrm4gPtb22S2rYQiRI2Ca0itdbmjVr" +
                                                   "I8/nE4pYljFzH3Td3OTT8TiXxE6eBxcIdBy2i/Y0aSlAw09E0gvPVC856W0z" +
                                                   "fEkdg9wShlhmFqJsTVHoGt4qQ2LvloMvqiNzucTFmJDuFKHJan9Zk7XaZV1V" +
                                                   "wfUFE0hK2BYs4Jhhz0PnWDOSAlIUfw+BeBLH67ZZCJcVTZ4x04SwjicJYejN" +
                                                   "FjxxRAksSIuoOAk5s0Wd9AukSnhXYSIi6yYDauXR7/N0tVc7TimjclkYasjR" +
                                                   "LnqOjrZiGc5wCTptRGW3bbdRmTc8oxPbdbGTS6NWcDoZEhgmnSqv1zYpgxY1" +
                                                   "RRkUGAKGgjZkvO82IcvvpD5TIp7f7i1mYl4632eiHccrWulj0UUD7xQdd4hd" +
                                                   "bFbylCfxkccvLuPuaKrBEUMuq6btvM4/HZcNsqRGBF7LBtscssGza1TfhCBy" +
                                                   "ognPdA+4gfh8X9uLnnBMTpVMznZIcToCxy0n4iYRntBQpc7uALf26O8sLqPr" +
                                                   "opW6eGEV9aY5HlZp0hxOSNd14y7SeL+KClPNfF7abs6or2xN8yzCu2hH70Zr" +
                                                   "fbG6NjYYdM8W/amUG6hfgp7MilQGA2uKyijXPDnyMt4DzaGCZX3YiE3UZl1y" +
                                                   "xj3Z3rWr+SbdDZE5benRJNIOq8hkVppnibB7mlyzjF7IcMS9Lm6CMWiKvsNW" +
                                                   "pgxuBXzvAycwP+Yg4l/oJUySnqYf7Q4ro74UF412YmOzjI4LznTKukCZck0A" +
                                                   "JLHxOgBlOvzUIXsLcU5babFD9JZJXAzA2EFBziW6WXXqarM0QNQ5Rjl6RpzD" +
                                                   "6dItU4wQ10WKtOActD1QEMEosZY8XKWbJoLtEO/3B0PdHk0U1BdsyuvecV5z" +
                                                   "prynQ1bg1kwbkaf5JldPvAOv3dGhZDY/QdJgWCbr7RZYcrgQ63kGTL46zckz" +
                                                   "MWnnHKXSMZ532U7vmLRUwSqEqvmRWmOE07K932gxNR9OGdQBQcJLS1lcrtYR" +
                                                   "AXKai7cBWeWykKTr2jBT10cnJGURZNZjKyb6nooAFsirjSCNihgIh2VGolkv" +
                                                   "+vxutQtRhLQuLgIQ7KmbN5uOWqmHRWEjC/BykPyq6f3i6Nkps2gKxzL25vJQ" +
                                                   "HvmxPkjxeMAdi6SW6fa469GRYVAUEhZ7Awyys2/BxJlKUX2ZqwWf4JkrjDst" +
                                                   "NAdwwSxxsKTXGjuXRlJVHbBrSDsCAsAFF9uA9oGKXlpZeqqhy4Xax01E6esR" +
                                                   "CwiYuATKejjnp2XTrdbzyiR1cmVQA7Qcuy2739SYsD1TesYsg2wR5pfyErjM" +
                                                   "IAYLseH0LDYbf2cWIJQuRO3iWEquttgGRhacJtGpeVlPQVEdjYuu5+YePVfo" +
                                                   "nC43FgESIkPLsX1ZW+Ou1Ij9UoXMi3a2Ln4NcGPotj0jTVto3rr2J57RkBLu" +
                                                   "qMkzGKstNleWiUFuGGnDHnB/sWFqVhykYxXVlr8M2pWOKymHj8V6vV46EdBT" +
                                                   "/vyM2EdnuwSJi0YK/r7gScVfUjJwJKBsQjVz3C0Ddr6fbNG55oDasuV32sQa" +
                                                   "k5Z2YgCJgNSDsq4Qu4IAj2vJsoC6LylOTKKdbqALdOXmjkht59DBxeetUe+U" +
                                                   "Tuo74QAu/EsDHTlgHV7YUncGJAXFkuRqa67WA+pSondaYpzYbZb2QBZg0u2A" +
                                                   "gd0BvZCjftDGBCIWMVRWbBU0LSrtSQTRHLVR2rofenlwDcLAJ/yFZQRnyNbV" +
                                                   "nKZhoaJsJkdQ2jxfLdXV0TG7cIgGiJfJvCw6EF/KCyGLPLPYbXxP77WCmBIN" +
                                                   "GgQB34UiKS+m2d68bg8YBC2qblPkYYzYsnUaVfQ4Ri2Xs2eSOi/29ghpGJJ5" +
                                                   "uFJnQtmhcLfzJL2B4V6Zty1QBQt72aX5hQ1w284Ef031UxZ8DEOFridfOxzP" +
                                                   "eif71nrYH+V9HGJpoCQnaso+PDqgwhhClkIJ2WaGJVAxT8Jg6ZApFUjiAQaj" +
                                                   "TEXFlhU1eXMiLRYl0fV2CXhcYawEyOPE2IsDqBHWDsFdILZfUArHclbcz7XB" +
                                                   "WRstMZ1XRr4OeUoj2bmCKKyThS6OLgwTKnJnh/Ur3V1E4gmKdic2sM5qGtLr" +
                                                   "zaoxpnj7aG1UIBXFKVgk9ic/ZSI07KczmNK9/RQDwqTNrU0dH6a8ft4ZMY/U" +
                                                   "eH9gjA5oaXwuNQXSNWnKHIwMUxixF5QqPZxZc5KlvTbw5mwELpuyGO4otJj0" +
                                                   "AYNG9Q4KZWKdHiAE8dbAuE01VgjrwgJ7E5s7aEAM2LLlZGak2uCw4+qFc4i3" +
                                                   "WJPq+7B14DDwFRcucB6fEhrdgRK13jLwOiwkHeb3AtwQQIAxso+VvC2ZwYDN" +
                                                   "hcrmYNBr0/XWik8tKh6DOtILb9Ed0XNZ6AXPo7562gIa25AyK8A50DhWhY/i" +
                                                   "spMOrHUGx6MzztnaDFVpzox7pyhPYbgsVB6Hg6McrWoQH6foNJTSAQJEMxoH" +
                                                   "WnCBAl0m6G5aa1XDO+l0ACfoyYBcQltkbFiTjLW2MrNDwHakIEJ0FEQLRaQg" +
                                                   "jvXQ641OnFBBZIRl1e1rm8MD82yv/JpZjaUXVN6mI5TEt9cZ2Sl1UNrmSigc" +
                                                   "JUYqeYiHRC/XCucQyGHVRwdQDdpgTq8Bwg6AwsKkELEXc4okGoIyaxrxnZA7" +
                                                   "oPk5Rxgo7Rk6OXjKct3zU7aLYAc6WpLUOhfmPp2MB9F2d2YTVOtzNsIedulj" +
                                                   "mcJdVkw9kggFT0SNPbTI6MaFgvOWo4TLnA5EW8RRz8S3g7Ct4FNlhFUfdgcC" +
                                                   "SODNnlawRmUXlBBsp7PzrGw8bD4KOEztdhBhJWFtBU213mxROyd4y9KnkKhg" +
                                                   "FsMedFP0gsW4XLTWbrMIGZ7Dk4KzqdWaProqyVd0vYIoxkXO2XmlzENyg5Kd" +
                                                   "EwpH4LLEu/MyN/Z7MsT0Y1vJ54mx+xXb0YYWbHacvoRhHbmcg6aXmN15MvBh" +
                                                   "f15pC5LZUVhz8Srb287rJkFjsKrchaK0jOT0SVLgbDYlsCTsiQDJe3i8ajxp" +
                                                   "KM/kYm0ZMOJx0and8ZobbUaTCBxZdKLK");
    public static final String jlc$ClassType$jl$1 = ("5yAtqymBPStbH53UY74u4G7EsL3S1+ezdxKUxI2Evi3QiD74YVpV2Up0J4eP" +
                                                     "Bvpi8u0F0bY4cSlYqRhQWNLGAdqf5vsVFBhK0slWyRgHsoqL5GhgXim085jr" +
                                                     "uh1X4gMBVC08mjRKTHlhRtBRkwdwOT9O5/2ooAB+lIx5RVMFVjvVJitlmRx2" +
                                                     "Ta2lYlR1oGw7Whc2TpsevCizil0rd5qeKikcL7YAnCirRRIlmb5O19qAEHsj" +
                                                     "9U5EdQ7m3EWiCxKKgEsn09h5OhtP0PZQwMWKI0SVTrKc9mWuJxqPtTCGKk8Z" +
                                                     "Mk9yWfP8aLkEsqBYqqybKxm7ZYO6B33yAI/bINUHQcuTdtwY7WZHl3Mdic7Q" +
                                                     "BMrWTBoORx3IkEgDMLI/H7opKIb3fAOIxI4vKWAPt7WE+DblGGkyaUg8n0N6" +
                                                     "toW42o6GauuVru14xO6YHeO+gMiVao8XGmAt46DMmVMYLGpaOfAxSLEnBbjY" +
                                                     "UOwr82w+AI6TycSmUwVcnGSkOfwu7mrQG3nXkztpMyA0bu8rZInVpCEHlSrP" +
                                                     "HZ5FT5f8MFiIpmggd6Zaj0oXgBKmMgqzOIbL9YEBvAtk6wuhSxt9PR0dhgqv" +
                                                     "qeM+2Z0u64HYpw7Pr5JYNjdMFNr8pt7QlJcKZ1zQJ0VZ20C9oxUZ3gzweV+s" +
                                                     "PbeUVVWGSXzv8Rob6ToWHlzeFYWq7xd+Y5/2cz+EIg2LFWQlVevRdegU9fBM" +
                                                     "ZFKkPmI4xcJbOYyDi3g4FiYeMweHwvVj7nEeLA/smVueADX3lltAyFccHPCJ" +
                                                     "vyF57NgmByoTkROwUDb2qpHXwpTRR5dufeZTYgMHWCyUttMjbJ8aDsAP21iU" +
                                                     "k+xojZBfr8pzFnONzO4O/mLb0dQpWy/tKa9AYpUuZVBd6PSpJzb46hyLhODp" +
                                                     "hy2GIytEu8xRJQYYfJMEWr3ibVX19ROhaXplcYEay/PJYJk1d8CcjTmPyIPW" +
                                                     "2/C4M9MTC6fezrFtfU4F0xGydeZHR82H4chx1bIOwUup6NKOXqRTRjwnz4Ht" +
                                                     "Wd2J3VpNtcnNCvTH5oR5CuhjSt0sfKWimsWUBqQ+DICdPQc4aWtv2N0Ujvg0" +
                                                     "TC/4DdtHkTAQvpq1Xq1DFeGnYJ9mlrZYZBupWNTrKZ0iyZ3ndSTpJ0cNEXHl" +
                                                     "HFODrq7YKdBYbuPA8wJKsSSRjVZzrF0zB811N0iWgjW3SVaVIotz07+cvX2Z" +
                                                     "Zd5cFXfnTMFlktvSB5TziuWcXcy7E02vToiijBapTsxTUlvDEnpbplP+ysPH" +
                                                     "GFJMi64sKJd7cntEFLrzKSEXNnRg1ifq0vthVNSrnUMnKNLOddawcIoQXSqB" +
                                                     "Y161cGGVV8OlyVZx3HiFDa7rHQZxmzBx/LNWiJ0SqrRFstuGl7c1V3OOhFfW" +
                                                     "IC9AlNqY3jwQFGojbrHqAPKENP0Qs6EqF1cdSTsbwyLHzuJa3DM+ssmPAJEd" +
                                                     "Is8ZHHLkULM+Dx2X4lJp4ty6m4JW+gwxh2BckudWSbeanQutKNlx0NbbWnBq" +
                                                     "ilmsL/WloeDc5qlp9n5Vx8bxcMmVQSZ5KoiWR8PSXaheWcfVOC9smsYtCafg" +
                                                     "ZeZ5aGjZo+aQbrGqZHu5aK+5R0bzVoK6zKHGminmP0VF5mKV5x7m3GpdLHfi" +
                                                     "GVSGI4hUq53uci5mgw1hK1GOO3UGYU29z3c27atE7HnjipvcvyCtBn3wjHnA" +
                                                     "kXAIyADtLQfWciwRqOzSAt0Y9YaSOYaALqm4CVymHEUV/MYDZfRUNdaCCorJ" +
                                                     "t1S93YAKu0JahG0EFllpQkkytc8BzaDaFMxCZMtmhgRgtI9U8MZB040sCaph" +
                                                     "mEEOLxa4kUEKmda8tGO9Qs0UkILIxXZntdlILEdul3FU1q6XdEcvJvQXEiZe" +
                                                     "Qji8xKvjeUoHJCo+iqwo0lEgIoB8GPp+t7EETIwPi+3xFHqDL694wCOUjSgt" +
                                                     "5nPraLi7fQ2QRj3P4JV/QeXtYWV1S4cTLSkXcSfntZUtKUKiSutFPS62DBNf" +
                                                     "1MhHHRJNACo4Y8Yx81Y9sssvgGTutvPFcdtVtcTm/YUJlsaWA2NtVVLn7nAk" +
                                                     "T5dAh9TUspUp1JmStdzdb8nNOUvYZOwV77iacqW9vFqkB9aLk37lxof8XMFQ" +
                                                     "mV9yrqoPgxj7WLiBVsKKZ8SusqajjAfw0RRMEWr1FQQirtV2y3Et5mB/3jtp" +
                                                     "1ZxNbcN19Yo1Fui4svnz/lJSe7sQjlUj7AP9jIjplMf6eLhFxk1WUBbHaVQO" +
                                                     "4jmxywbu2Eoq1mANVMcLPQlaLIrh6fyk99lJXhBu4thTKISirBwYUUJUsGK4" +
                                                     "pI/sVT47TNG1KwGC6YxojTattSoIMVR9xO7XiAApNVF7mIYBEo0YIbCt7eX8" +
                                                     "AnihhK4hHj7jMZUui10NintDIoyRTAq6PMEEoejKwYTSvZUsJco/KqkbsbLr" +
                                                     "hpYfAKcp8suPR9ovCEUj9ZLAVqoeTLbdaRWGLv0GMletDRKFczZ00wHRYiWq" +
                                                     "ziUSARDfQkws43OLXJznMuouSTxXSlfyS7LGyZ27ZMOgQCaXjEs5zztnQbMF" +
                                                     "by20ZLDNj7s4RE/gRcXCrWbFqB/nwZxUGNUgL2aYEJQ6KWDmyL2LAO3lsp7S" +
                                                     "EpeUsON5rqetahrZmm8jy890vtopWmqv+cWhJSOJRuG4jGXfxywHIFaTPxhZ" +
                                                     "ua8sgwt6CpxvvGMu26xUliRAGyacHs+Hod3zrLifK2pV0EuAP8oMs9FOfj4G" +
                                                     "YrcPaCbHhG2oecyqJPf7gwt70LlOYt2hnJW7Do39oZN1g9motLl3uHa8nHWR" +
                                                     "3XHVmKidpHTIuh1McpD0usG24zbWzSKKGCQ7TwsjhEjuxot5QfmzOoVIWnHZ" +
                                                     "mgClqfh6CgfNEBnL2lM1ld3R5JIgaWUuHkzl6CMYAoWok8jcGHi5whzPYV4X" +
                                                     "i8bJK6OTvXlc4zyQyDU0RAiycMxQPid8FuVhte+VkzN0UpnJaFq7yJCvrKLA" +
                                                     "PU30nLnkQLK1X3vtBWTbDSfJh5XqJdB2zhFjMYW6i1Prt9y40mIvXRTeesEO" +
                                                     "FTGwKAXwVHlu3DY21htAOkMHy0vOGkG1vbonMfx2UeCP3d8q+OTtzsPja/NR" +
                                                     "6F8HfuxFFwce/DbAukVA8axVrjYIzVJO61x83pKnRDEVK4kQNiN/IKoY0NJw" +
                                                     "XGF7i7P0Dcja+KLMyXR/EIFu6NaUJZt7V97pHEEx4Li7hNulqWdHY3sWZWAR" +
                                                     "qO7mgANrnO8sdJ22oisi4HlbVM1e7vGz0AmYlNMsCsJz7zjyvbqjpblzmPRx" +
                                                     "cpoqoAloQeIEyAWBQKNNpMjcMC7RDjubEsAfSA9yz4C55cMyjsljtJuCJXK+" +
                                                     "iJqOtPxkQCOWhWPanWcaChaQBZzhsuNgpt3tnXm5XfJH0HG2w3YuRcqoVmJ7" +
                                                     "aHpe9alORj3/vDucGVUssKzGt1K/YFBSxjZ+6qimaZdR5i/Bw4blD3QJdNrO" +
                                                     "kJ3KZ/FE3hZaXeG0HAkujKGFogPCEUyNCxYNC2BL8zp9RDBNRhU+AhkDqIjT" +
                                                     "MJ+jTNWAPUZ7F9SEZAn0DnMbGIyKOy6twcd97mQhvlrWDROWSLxGp0CLF48R" +
                                                     "oOHSlLNm9CkDGc4ZQHIHy5fY3g/LgonFwEzUUte6DK1pDqxkVx6P8ypB2906" +
                                                     "W0LQIrdwGSHXc2SVIJLHpwjfaTiATFEbXfRojI6+CIR2rsw3Xb8UEwNHzF7D" +
                                                     "cZir27gkFuuoao66JCAbQecGGQ1gcA2XA7IITjJYReDyUmdeNV8bQD9kiYBm" +
                                                     "lknkskTgw5acl6DVOoCHrvbOfnTc5U5LsbS7LH2LGo3QGhNaC6Xt0S+H7EIw" +
                                                     "jT1nQHd5rnQ2iabUPQvxJe6Ox8ov47aRnR1SlFQHL8MOVjJYWc73Xuwvpmxu" +
                                                     "sBubJMkfuKr9v3lvJN/6LiN5E34PM7m7+PQnXnJxjXzmztF3Xhe7XeJ+/t72" +
                                                     "O7sryJduW/RPLlJ9z+OLVLe/1+6fMfzcff2zT12keupe8Ox6OfOz7/Xi5HYx" +
                                                     "8+f/8Nd/7rT79+AH9zfE2Gb24SYvvpR4nZc8tdQbt3b4GI2PPnpVMX0f+NP3" +
                                                     "9R99+jbYEy49R8ENs4/cT/kj9/WPPk/Biy+w/TsvGft3r8WfaWbfdmXsm88z" +
                                                     "9s0n+ITP3ml7a/q+MJt98MFd/erffQkVL7jQdp3yv97Xf+u9qXjlyQXjH7qt" +
                                                     "+hdeQsp/cC1+vpm90Rbnyj55t6uTt9t/LxLDw+n7/bPZ6z9zX//Y+xPDdcq/" +
                                                     "fl8P74OAX3oJAf/RtfiLzewTgZ2dEu+pG7QvurTW5eHpRYSB06dPbeu+Jt4f" +
                                                     "Ydcp+H0N/vPp13/+krFfuRZ/uZl97Ow1zxH0QrFcryV/ddKxL93X3/r+sL9O" +
                                                     "+dR9/cb7EMtffQkJv3ot/stJLFcSvBv+d/cQr/3yi4zjirw3m33L77qr3/g/" +
                                                     "359xXKf8w/v6t94HEf/tS4j49Wvxa83s26/XaydfFvrDP5OWm0A+P30/Ppt9" +
                                                     "4h/f17/5/gRynfIb9/U335uWp1H95kvG/udr8Tea2acm076+NiKf3H69jvzH" +
                                                     "76VSPz2bfeqn7+vh/VFwndLf19U/HwV/+yVjf+da/M1m9unaa8h3vT54ERG3" +
                                                     "t3jfdxX17O7vVjezb777kdTDt/4lv5H6wvc/LFu7Dss2b7y37h4fPbx6pofX" +
                                                     "wzrMujz2aM9/6mnaW194+CNNENZvv/jAeesLX/7aF4riveVy+3vteW5cR/9e" +
                                                     "UbyE77/9krH/41r83Wb2mfdC+kViuYYQt7czz4nlP/xXTyx3L2OelkvYXOXw" +
                                                     "8Ie+qj58Ebt/8Fl2v/4idv/Dl7L7H71k7P++Fn+/mX3oES4vYu9t88++i72v" +
                                                     "/Bf/yrH37nr8w3vlv393c+Pzo9cKuf/WD90eYFx7f8ROna/drrPftR6/Ybv9" +
                                                     "vM3bffHhPbjd2c/D3702uAPOv7qZxBj6D9/KH4aPN3v4PPZXUT/f99B9+AMP" +
                                                     "33oXZP7lh3dvKR6++5Gdfn1S4JXtpE3JxFotf8t9+yUx+RdvpEz2fL+gbye1" +
                                                     "9y7rfvGLlWvxo/evGJ9VpAdPoG4Bf3mFemX23ur2yg32/5lCkGdFcu3dPK10" +
                                                     "j56ffuaRsj3quI5+9l8E1h9+CdYfvRavNrPP3Ths182L2XzDqZ+Ck+cHrk8s" +
                                                     "P/Ou/3Vw9yLf/cWf+/iHvv3n9P/x7mnTo1fzr4mzD/ltkjz9aPCp9mtF5fnh" +
                                                     "jbzX7p4Q3ljyysenYPSK27V9dzaW/f8PignPhW1BAAA=");
}
