package conf;

/**
 * A paper which may be submitted to a conference
 */
public class Paper implements jif.lang.JifObject
{
    private String title;
    private String paperAbstract;
    private Author[] authors;
    
    public Paper conf$Paper$(final String title, final String paperAbstract,
                             final Author[] authors) {
        this.jif$init();
        {
            this.title = title;
            this.paperAbstract = paperAbstract;
            try {
                this.authors = (new Author[authors.length]);
                for (int i = 0; i < authors.length; ++i) {
                    this.authors[i] = authors[i];
                }
            }
            catch (final NullPointerException ex) {
                this.authors = (new Author[2]);
            }
            catch (final ArrayIndexOutOfBoundsException ex) {  }
        }
        return this;
    }
    
    public String getTitle() { return this.title; }
    
    public String getAbstract() { return this.paperAbstract; }
    
    public Author[] getAuthors() {
        if (this.authors == null) { return new Author[2]; }
        return (Author[]) this.authors.clone();
    }
    
    public boolean equals(final Object o) {
        try {
            Paper other;
            try {
                other =
                  Paper.
                    jif$cast$conf_Paper(
                      jif.lang.LabelUtil.
                        singleton().
                        toLabel(
                          jif.lang.LabelUtil.singleton().bottomConf(),
                          jif.lang.LabelUtil.singleton().
                            writerPolicy(
                              jif.lang.PrincipalUtil.topPrincipal(),
                              jif.lang.PrincipalUtil.topPrincipal())),
                      o);
            }
            catch (final ClassCastException ex) { return false; }
            if (this.authors.length != other.authors.length) return false;
            for (int i = 0; i < this.authors.length; ++i) {
                try {
                    if (!this.authors[i].equals(other.authors[i])) {
                        return false;
                    }
                }
                catch (final ArrayIndexOutOfBoundsException ex) {
                    return false;
                }
            }
            return other.title.equals(this.title) &&
              other.paperAbstract.equals(this.paperAbstract);
        }
        catch (final NullPointerException ex) { return false; }
    }
    
    public boolean equals(final jif.lang.Label lbl,
                          final jif.lang.IDComparable o) {
        try {
            return this.equals((Object) o);
        }
        catch (final ClassCastException ex) { return false; }
    }
    
    public boolean equals(final jif.lang.IDComparable o) {
        return this.equals(this.jif$conf_Paper_AuthorLabel, o);
    }
    
    public int hashCode() {
        try {
            int result = 19;
            result = 31 * result + this.title.hashCode();
            result = 31 * result + this.paperAbstract.hashCode();
            for (int i = 0; i < this.authors.length; ++i) {
                try {
                    result = 31 * result + this.authors[i].hashCode();
                }
                catch (final ArrayIndexOutOfBoundsException ex) {  }
            }
            return result;
        }
        catch (final NullPointerException ex) { return 0; }
    }
    
    public String toString() {
        String s = "";
        s += "Title: " + this.title + "\n";
        s += "Abstract: " + this.paperAbstract + "\n";
        s += "Authors: ";
        String sep = "";
        try {
            for (int i = 0; i < this.authors.length; ++i) {
                s += sep + this.authors[i].toString();
                sep = ",";
            }
        }
        catch (final NullPointerException ex) {  }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        return s;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501499159248L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAM08CXgV1blz7w1Z2ImsQeASIohCIou4RGRJiAQDRBIQAxom" +
       "cydkYHJnMjMXApb3oVRj8RU/KbhUQWpREVGs1ad1r5WCz6LS2kJtXYrve3XD" +
       "Vru413f+/5yZObPcmxuQ+vJ9OWfumfOf859//8859+45JnQzDWHYCqW51Fqj" +
       "y2bpHKW5VjRMOVGrqWvqSVOj9NmPfpW45TL9zaiQ2yDkK+bCpCk2yzVCgZiy" +
       "WjRDsdZYQt+aFeIqsSxlKWpZjWJa5TVCD0lLmpYhKknLbBP+Q4jUCH0V0iIm" +
       "LUW05ESVobVawsganUy0XNWsMrndKtNFQ2wtQ1TKaitU0TTJSLnYag+Srxva" +
       "KiUhG5YwooYgznqrYpOsltWydzXwqbzdEOL28Gx9dHE4Ml3d1jPLttx8Rd+H" +
       "YkKfBqGPkqyzREuRKrSkRfBpEHq2yq1NsmHOSCTkRIPQLynLiTrZUERVWUs6" +
       "askGodBUlidFK2XI5gLZ1NRV0LHQTOkERZjTbqwRelKSpCRLM+zl5DYrspqw" +
       "P3VrVsXlpiUMdMlCl1cF7YQW3Qk5ZaNZlGQbJGelkkwALXwQzhpLLiYdCGhe" +
       "q0z45UyVkxRJg1BIOaeKyeVldZahJJeTrt20lAUELko7aDkwQpRWisvlRksY" +
       "7O9XS1+RXgVICACxhAH+bjgS4VKRj0scf47Nu2DTlcnZySjinJAlFfDPJ0DD" +
       "fUAL5GbZkJOSTAF7nlFzkzjwqeuigkA6D/B1pn0e/c5H08cNf/YA7TM0pM/8" +
       "phWyZDVKO5t6Hzq1Yux5MSqCmqkA8z0rR+GvZW/K23WiWAOdEeFlqf3y2QW/" +
       "vGz9bvn9qNC9WsiVNDXVSuSon6S16ooqGxfJSdkAFakWCuRkogLfVwt55LlG" +
       "Scq0dX5zsylb1UKOik25Gn4mJGomQwCJ8sizkmzW7GddtFrwuV0XBCGP/AuF" +
       "5D+X/C9j9UJLWFh5/tKFpmxUkVHMpZWalGqViQIvXZhUllotsqmYSyXRlBtN" +
       "K5VQSA8i0Yzq+NhIFHKpaUj4YWmtSFhfSpr0kzVwO6yo7+pIhBD7VL+qq0RL" +
       "ZmsqMQeN0pbUzFkfPdD4YtQRfUYLS+gOQ5bikEIkgkP1B52gPCMUX0l0l9i0" +
       "nmPrLp+z7LriGBEWfXUOoRd0LfbYzgpXwavR1klEyn4zTV+26eyhF0SFbg3E" +
       "BpqVcrOYUq3aiplaKklsRX+naYFMzEgSjVeoAc3TJYSxhEEB00dNHgEz3EEA" +
       "bCiR7BK/foWh2afjnX/uvWmd5mqaJZQEDEAQEhS42E97Q5PkBDGJ7vBnxMVH" +
       "Gp9aVxIVcohVIGuzyMrAyAz3z+FR5HLbKMJaupHlNWtGq6jCK5sq3a0WQ1vt" +
       "tqBQ9MbnfoRLPUDUVfLfi3BsB6unwdtTdCj7UyECtvtWgUZ3ap2+7chL706K" +
       "ClHXPvfh/F2dbJVzNgEG64Pa38+VonpDlkm/12+p/cHWYx1LUIRIj1FhE5ZA" +
       "WUFsAfF6hMzXHGj7/Ztv7Hw16oqdRVxiqklVpHZnkdAudGeLu5DV53KLJLON" +
       "dvEhNkUldo2ga5YsTLZqCaVZEZtUGeT8yz6nTXjkg019qRyopIVS1RDGdT6A" +
       "2z5kprD+xSs+GY7DRCTwaS7N3G7UUJ7ijjzDMMQ1gEf7Vb8edut+cRsxucTM" +
       "mcpaGS1XDGkQI0CDXNVDaZcT1KrftWvPA+U9770LOVaA2kHcPq5iKGEUQNif" +
       "uyPvezlkhH9hGCPfJayexcsKmbfInRcHJygvRwQapV299r14bHDVARTyqKRY" +
       "wrCgBiUcrSjnbRER5JROjBBqOEM2uooMcap/iEWiR/kG+fFhyORcHk98HC9e" +
       "gsj0SMimZCi6LaIwnam06iphnGxPl2tpcwgjnMjKEJOmSjwRNS71+HJWu26A" +
       "X18lGshxpN2odhB3B41aCNgapXOu7zC0URungOh6dXJQGJ0v5ulsCXWw6lbN" +
       "0FsUKY4Li2vNcar+cdFYjg4kbimWKsMLLraKn94ENJQTcbFJWyXHm9bEr7Ra" +
       "FHPdWBj7fMLC0xBXe3mlFWIyqVm+RTZKuZLyyLGy5q9oeDDCCxPofcFZFdc2" +
       "Tv7JwShT7kF+JzJbNFuIETiiHm7Y+voZw+monJFg7x+vvGbrTY89Opn6mZ6E" +
       "OH2nTRfwD6kYt4RuuGoyx1A/6+vJMhn7b/pn/wVXX/rpQlSDqITyPoLIf3NK" +
       "Vec5DhDKc3RC7lkOiYk7jpu6LJEgN25zOV4MBCyOK8m46y6XUJAZmAfgrJfr" +
       "yOKpyMS+Ht8KHtrjK2s0SVRd/1D/n/sPT7n1nc1oL7qpvPvyR3o+SHWnur/m" +
       "72teogT1hwGcsjRKE3e3/iNanLsvKuQRV4wiQ/KRRaKaAvPcQMJrs4I11gi9" +
       "PO+9oTKNC8u5kHSKz1Hxip0DqLj2prfX3oxi8n9pmL2JCPgwF0GKsTwNitNt" +
       "V9CtWUmKKvMEX5O/CPn/F/zD2NAANcG+goWXcSe+tITW+cZyMamQuOzotZuP" +
       "brzr/G8ySptLHDwEaedPOGvcxCnjJ52LK6lATCdAMQmpMQsbBpAkElUByFtK" +
       "MxHUVigWURiHbKfBkiYwcsmsvsxjpqGa7ACcGQbQ6LU3S7KyNzrI8owmCMwk" +
       "q0t2p4GqBpbTw/W6l2d07Fn5b9FNaKr2kncao5IZRl4mlYk0UgmPl+CiFkDR" +
       "6LL8MmxdhkxFooSxdwbML7F5b2Z1KgN7F4UBbPSytyEr9tI9DbNzxnKERe6u" +
       "7Jy7eWxwryWkdhs9JjPc3f8hVjx584x5aAl74eaHbcEsYQgX+Nfyr8qpKXdo" +
       "AtZEaGK0uInV13tpQlOHOE4hk4yfXxWSAPJwTqjArfncIOLAu8EjNV9tn/q7" +
       "px9BNwgAQ3xxgWuNp7ywO/byoqXbaKDGpQSDuUVCVsXtOrDtjuHpyEB3O5AW" +
       "Fzu0OAVoUcKyXIPVIk8LgQr0leECHYPHsSTsNnF3iBNvS+jB0cwM+qpaQ2kl" +
       "ecEqtishX7dl49elm7ZEua2bUYHdEx6GW1AvnBJC0JGZZkGIqj/vXffErnUd" +
       "1CkWejciZiVTrff/7qtfld7y1gshGbHrfft6ZTVI6eK38zqq35lDYu0Y5rYV" +
       "GlqlJA2msKk66W3qoZgE3aSk6MRtwSTXQNEhRASfGUIzsJJJ7h1hZoCZoY3Z" +
       "mSHdNUMrsNX0BvPo+TH9oLzaP2nw1o4ffDKIiGeDkMciA4wR5mlJ/BCydcXB" +
       "/3XPm+//utewBzD+zmkifhNDAP+eX3BLz7NTh5j29BJlkW3i0tpGnzGtZx2v" +
       "SwvQ5gDMBoA61rGD1d85McMBcFtxhlWcnhGf3wP7UGhsKwPGObsr3oixCsjm" +
       "mg9p7dT/3fyvthKUvd4tIpE0ogOwMysbJOFR3E+W0M9vL8o7CzJ9kzWU7bm9" +
       "qOLC91FdXFuFQTW1NlBstkXyjnCRjKIh8diPXFVOLrdaXNncTBlSSZ8tYXqX" +
       "nD8lJceOJY7fx+oGbgqcbgsishWKW6G4DW18aKI/q1W3MDVf+9ighy+4Z/sb" +
       "NNUJss17oDAXpdkl5Tk/qiw59bm2Td/cfhjyMHzra4SPrX5k7p2754WLRksk" +
       "7Yg5u16BvXQvkD9rp7PWe0L84ZTMUN5DRQGK0chz/HymQzYByUajhIcyvHsY" +
       "ir3EOkuqlpR5ZkK5S9f1SEQQAqBhWWKtqBgs2Bj4cXGZXlX5FvpgDAlrNVWR" +
       "1sC2g3+LscJ5W476ZcnL7c7DAp2r3dfldpaJqvEEbHz5gwiGDx9IbBtw85OF" +
       "922eYe8eXBgaW4HL9S9vgSwmZIPO3Sh9vP01ecHZn31IN/C01Un/0ZFue6My" +
       "xy/BqZOBo8CczxI5GhygIRt+yvd37D32Ru10NAzcloo3imHHUxw5eutY/cK7" +
       "h+zgUlqv6Q46jdIVA18589QnL/sevxXhA+B6b7r39ry/jPtsBy7Z2dQZ5dvU" +
       "cQAybuxAeZ7ejvuHHqbxCPJ8GzTg9VcPrJr9IUXVz+kwiGkT+z/9zuAhV7KQ" +
       "EWZ8Xqcm6oAexuBLDcVyGRwvrXnumbwF/80xGLlGlr4aO1IeQvlzSvSXnC0g" +
       "Hw1napaltXKUnDrqtRXlXx162BbCfUiJsd5F+aA8W0hnPDFk0x/Wz7fhX6DL" +
       "e5kt7xD9+BhTjd/ipyfDBR0an6H4HwkbxPfxIO36up+c3o/tsIUwOJ3nwE5X" +
       "sagTqu9aQozoPZo16uh24iy7obiPRlwrs/QzPBy+OyuD8XsXingkEjRvSD8o" +
       "RhJf2TdBHUdcZzkevHifUpUu/RnaFcoPKS1og4c8waaDLtjfKLW5PjYDPE3I" +
       "T/phMNuyhufbnTgLTt8w1c4n/8+y+n546wtvP0sTS5CMkkgu0WyZBhTew4B+" +
       "bMQ9rL6DG9nZQUTueDEazvr/LAyjb3pLggwXiabdloAW3CXoi4RgPX0UHE/+" +
       "C8j/X1j9apCCkdwM0dhX6YgHg/2G1b/0EC9kmyaEiAD3VhhSJ4OIvbMmYu8w" +
       "Ik4V8Jwscharu4UQsfB4iAiD5dBa+MRDRGc3JIR8kxnkmDB0fOnK6QAwiXUc" +
       "zeqhPMBxpSuRokC6coMXSRu5orRITgjqOnQcnMWqhgBACes4iNU9T3xVxfyq" +
       "0BYHwncUD+g7wub8mCyTGSjudCw+gXcSGfJ8MhIZewqcDq1zBONscDARDLZ3" +
       "hy5vD4WFshQ+P5je80QmZXh3NhTo3R7pHKd0ATp8fqINvUVGZwxd3kaUKVfO" +
       "dDwvUdsIp+FF7VzG4UgU/uWy/3pWz+MkinNVwRyuLkWsHXctZ/Hpi37+3SHm" +
       "9TTIG+skWXK7VYoCyUD9cL8/EpvYwyq5AWM1Z08kn8RtJvS0hHj6C2E4Fg2e" +
       "ezjLwossoILdCdoiq+dZwvllLVqrXLZCTpSt1oyVZRD6Jkjqig+q0jTeNCT6" +
       "DMc5ZIX0RIfdVjkBaOT4dHt/oxCoiEcaTie8XxKgbaPU77zbmpqvnr4fE4k+" +
       "SA7kfB0lzGjvnigDKqnz9vPeeQvlRqP0zt7vHxj53qJT8DKTTXj+SsNcUS/3" +
       "X2GA00nS3i3vtZ//YuCyQzEhWiV0VzUxUSXibRChwGoxZLNFUxPtOotaI6sh" +
       "gog6euc6iKHwehxjl8nqJiDdTJThCrYjG0lz8BVz7kA4u7IndBSmE6ZHapx4" +
       "N1KPYnYtPFZi63WEQpK9uUljS1uZXatdDuNXMd3awurvnbjVbuCtdjtkICVh" +
       "EuQXhgnl0rzntPPGokTlgnktOQvvYYQIUjlmIJE5MPiwdNfxcMt359Vbtifm" +
       "3zXBTmmusQjrNX28Kq+SVc6I5FNT6xAH7+HEBTz3jxmsvpwnDtqwMNvl3G4B" +
       "kKWsXuS3XeE2ekWGd5AeRGRLyF8uW/UhATGiPIjNp4ShfDJiufTndNCyKFMS" +
       "FKE34j6Ax1SnyaQDEGl38h7S4E+FfE0HXbB1Tt5j9+FSIbcJnVuYNMDJ90hC" +
       "0idY/eOuSQOA3Mnq27OTho4M70BRI1dbQg8iDWmCe0cgYMq9YVifDIH4/gkI" +
       "xAZXIDZnJRAIENnqcn9DUCA2BAWCgv3Q5f6GoEBs6FQgzhUwTM4ZSevY37sm" +
       "EADyN1Yfy04gdmZ4dzcUdxCCg0CEZiuI9HiG9MAwpH0eYqTt9wBgAKu78wDH" +
       "5yF2Z8hWHMMLcxWkRdK3quEMIC+LVWF6M4wB5DKAL058VQ8FshUSRMMl3QwC" +
       "v8MV+EezEngEiDzuSveOoMDvCAo8BXvGle4dQYHf0anAj6f/OS+xek/XBB5A" +
       "7mP1XekFns99XDaXwiiTGfRvWf1ygM2TYSUvZn0hT4NGeoAZl9tSomqGXYs5" +
       "unHn0Ws348WYyK+oeUvPJkzX9lFywOMvMy2PYstjDuVBjG5e0r/V8YKX0xYm" +
       "Vya11UmaG9X12JPa8NT4I3ZgxY77cb4/ZjBTb0HxPImDKbnh0xvhB0GBjXQ2" +
       "PzsL6l/2wbb5nx590EbgHLounc+7I2/7GkncrFHt8wrWFCZQh8MEyxL62Tu1" +
       "RHDiTewQL/JuVhr7Hi7b3b4lDQGNfS+osRTM3b61+/Aa622qpk1sG+RTqopY" +
       "prlm4BDDe52NJX5+GYLiXyhHoQuGN69A8QWSBlGA4kt8czi9REQjKBFQ/CnM" +
       "tI9mLNkfZnTCzgvnaIotI/3y33zrmFE8xT4vbNW1pMxOZEeRliSaA2Utu1Ps" +
       "u5RUGDb9T/np8cqQ79DImZ4/WfnDocN337mxR7NzPKjjoU6nN9TrZGv9sM2H" +
       "brht/UIbdFwI+WMnIZCL9kwbyPkcKmwRYnQM9Hme1T/zatBxONRo30CYEGLT" +
       "oHwNJNkVO3bK7zsKymvSNFUWkxn9MbWLH9ABuEMYsCGuuu4LavC+oAbjWNGR" +
       "rrruC2rwPo/P9S7D1Z5fZ9Ce0/3aA40xHDaaA0Uus37RPFoVhMkP8tuleRo6" +
       "/9ZPZ4AY+G8m6LldImhUGxNG0RcyUHRaFhSFagalalrz32VKQ2tVW2YL61sR" +
       "IjwjazZAxzlZeS1K67nHx6IFXWBRWJwJd59nC0J+nNZ5n7cJXYkzAeQzVv+N" +
       "A/XxPErPBXw+ZyKMcg5DYDSrR/IIOHyLXkEM28Ks4ky1Se1qpBltzCbSjC52" +
       "IrnoZZkWSPHlcYdyGUqyqH9j40Gh0jGhlCwhRtbuC7mQxuWMtmeE0Rjk5H0Y" +
       "IJmNtEY1nNxwRJM0+KXV13TQBVvtiKbdh5NWX1M1baIxVvQ7ncdY0K0VnjbY" +
       "lBE2+CQOjjOFakaFc1k9Llzi1p+8zCZ6VQZ5Y7wMBM+Iex3DeWYY7g4nr82K" +
       "kx041UaXbR1BTnYEOUnBbnDZ1hHkZEeQkx02J7dkx8lroENkqrN8PM8ZRs1W" +
       "pIrVZ1nC1C6dyFRXsi9QkgCNHemc2ABIjJsRSxLaD3BOdfh+uJIqLC/u9AAE" +
       "tlfQBMD6FrP6IpjlViTfD9kBSDTNTdKTfAASvds5AInCTZ3I4rD0sXJNUmxV" +
       "JJYa3PPyLx798aD68fRGOXzfPOwS4QxJkk2zlrz1f2OhBpCbzyT+QlaX85Jv" +
       "CVMSdEqmpYasG7JJlJOoIFE+iM+RBHERZ4kDEuAp9OD1NR53Pq9478Eb35n0" +
       "/Iu3evKKEf6Vu6vAL6NNqC4654KG/3oOryIXJOVVsjEvpao1QlRVQr7h7PkC" +
       "m+c6aXsIld25FmiadfaN6gM/PfvdpfTkNfhdVKezlnNe+UVPzB4d9fxkAczS" +
       "h0Zb9wtocak/aUepiVwBTdvQdqHEo9xnOEKJQlISvbTzzYc2tnVAvGFwP4Fv" +
       "pOigo0L0OPtOzTVvuqG8GhezAcsWFk5HUXC3uEuQMyxhHy4Bisd9fgRDJ9ub" +
       "DgkLnWgI6wAUhgDkR3iAzjOHnHQRBVuglzw4zG4HAUwch7KJWeSWn/cN6RBM" +
       "tZdWP4HiFV6AEAU3gz0VEBnDEBjI6h5eRI4ng6XRrT+D7VwUssisWKAWzKxA" +
       "PF1fuTjoPhcH3SeOFX3b9ZWLg+5zsSdst4QcQsYxXZF8KN7DJWcKMWh6w+hA" +
       "3S083oLvj6GFz+y62mw3FN2NduP4ZQjA/0rlKG3UQmXLMU5IFN46fYh4L82g" +
       "0J/6FRoe93Pp5gtUGj6nqpgek+zUE4qvUUUzccHHXJecr5wQOWPRrMj5ioec" +
       "riL5pCmW3zVpwsbPs9YsmKFnVkErAsT6HJfWxfp3Qevw2Zcsw5XCWmKuvmb1" +
       "0TahK8kygPyJ1X/gQH0SG34oMxZGOZtCF/RktcAj4PAtFj95qUtsZIbUhdIM" +
       "ehU5qW1saKblUWx5zKEshhXFRunf5nhgVt5A6AnpLUpsEhRDso9yyMTBKIdv" +
       "DEn8kPOVjONDwzjfxhK/WHk2OhS7AFGf5igMafDrkK/poAtW6SiM3YfTIV9T" +
       "NW2iiV+MfoEzq2MSzhHF5rZ17ohwzM5yqG8/V6SZW6w2nBCwXxm5BApIgCN1" +
       "yNZ6yL7gAd0WzbigaOA8X2xeQOChWIxCn85kx2DmWA1KDXIHaY1vxmUQ+CUo" +
       "8FBM9hkotJAjmXn7NMxCUj/rABSGAbzLA3QeE0d90SV+oXs4G+sfrH6PH/O4" +
       "osuYFBpd+swLlGUsumREzSK6ZLYoGF2CWXAVsiioo0VBHcWxYm2uQhYFdbTI" +
       "F13y+LpCMCaDELT7hQAeL3fjqFhjNqxz6ZqGlmf8f6DldV2iJQ2CAsQcnoGY" +
       "N2RBTKhupARNa9u7QmQobmrLbB58i8HG");
    public static final String jlc$ClassType$jif$1 =
      ("G7PmADz+MCtvRMm87fi4c2cXuEO9v9dewTcp6ok7TbF6aZvQlYgOQJaweiEH" +
       "moHdezK8ewCKeywhv0U0W+D3wMJM7FA2nxqGss8c9gGAItZxJauX8QDHZw4D" +
       "96/ezigTu1yZyOrqFQWIuVevSENAJnYFZYKCuVev7D68TOzqVCZgc0Ihz0dZ" +
       "zX/HKwuZAJB9rH4mO5nIcEQaexGK54lMWBr98aMwmRjO5vt9GMo+mXDu5EHH" +
       "I6w+eOIy8bJfJjLeP425x6SxV7OSCQSIHXYFIHhMGgsekzKwP7oCEDwmjXmP" +
       "Scn6uzm/ajM48DvB9LdtpQe298kftH3hYfojHvaPfRWw31Hjf+OLe84l6Xuz" +
       "gisvwJJ+2Tv2Nsm/gZrw/D94/v9lO80iBvOEC5eQP3t/8hB+WCFFfyO5Ufrr" +
       "xAmVTx8YvZ995zrtF0BciL3b58y78qMp9EcSuxFGr10Lk+bXCHk0eUQc4Fcf" +
       "R6YdzR4rd/bYL3o/WHCa8zt/UBRyOuRZ3WA3HbiyPWxv3fMjzo3SSmHd9c93" +
       "FF6FP8NSoJj1Rsq04OeUCyT7ewkw1hp6mkC/SR37Cxl4jP+r59yw/I5/ZMWt" +
       "82vyvl6c+YcG6Des/g/daPnIMlsAAA==");
    
    public Paper(final jif.lang.Label jif$AuthorLabel) {
        super();
        this.jif$conf_Paper_AuthorLabel = jif$AuthorLabel;
    }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Label jif$AuthorLabel,
                                         final Object o) {
        if (o instanceof Paper) {
            Paper c = (Paper) o;
            return jif.lang.LabelUtil.singleton().
              equivalentTo(c.jif$conf_Paper_AuthorLabel, jif$AuthorLabel);
        }
        return false;
    }
    
    public static Paper jif$cast$conf_Paper(
      final jif.lang.Label jif$AuthorLabel, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$AuthorLabel, o)) return (Paper) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Label jif$conf_Paper_AuthorLabel;
    private jif.lang.Label jif$jif_lang_JifObject_L;
    
    public final jif.lang.Label jif$getjif_lang_JifObject_L() {
        if (this.jif$jif_lang_JifObject_L == null)
            this.jif$jif_lang_JifObject_L = this.jif$conf_Paper_AuthorLabel;
        return this.jif$jif_lang_JifObject_L;
    }
    
    private jif.lang.Label jif$jif_lang_IDComparable_L;
    
    public final jif.lang.Label jif$getjif_lang_IDComparable_L() {
        if (this.jif$jif_lang_IDComparable_L == null)
            this.jif$jif_lang_IDComparable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_IDComparable_L;
    }
    
    private jif.lang.Label jif$jif_lang_Hashable_L;
    
    public final jif.lang.Label jif$getjif_lang_Hashable_L() {
        if (this.jif$jif_lang_Hashable_L == null)
            this.jif$jif_lang_Hashable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_Hashable_L;
    }
    
    private jif.lang.Label jif$jif_lang_ToStringable_L;
    
    public final jif.lang.Label jif$getjif_lang_ToStringable_L() {
        if (this.jif$jif_lang_ToStringable_L == null)
            this.jif$jif_lang_ToStringable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_ToStringable_L;
    }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501499159248L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAOW8Caws2XUY9v4nZ4aruGijKZH6FEf0UE1OVXd1dXVzRCm1" +
       "dVV1VXV37dWloUe170vXXqXQkINEEmRANmzKlgFbCBwJiW1aCowIQSAIEYJY" +
       "sSFHTgQjdmA4cggjCxTBcbwbtuXqfu8v8+fPFwe2Iht+wF3qnrucc+45557b" +
       "OPd99TdvXqjKmwdFngx+ktev1kPhVq8ezbJyHTwxq0qeGt6wf2IGfOWP/74P" +
       "/4V33XzIuPlQmEm1WYc2nme129fGzQdSN7XcskIdx3WMm49krutIbhmaSThO" +
       "HfPMuPloFfqZWTelW4lulSftpeNHq6Zwy+uaDxu5mw/YeVbVZWPXeVnVNx/m" +
       "IrM1gaYOE4ALq/o17uZFL3QTpzrf/P6be9zNC15i+lPHb+EeUgFcZwS2l/ap" +
       "+/vCCc3SM2334ZB3x2Hm1Dff8fSIRxS/zE4dpqEvpW4d5I+WendmTg03H71F" +
       "KTEzH5DqMsz8qesLeTOtUt98/G0nnTq9pzDt2PTdN+qbjz3d73gLmnq998qW" +
       "y5D65puf7nadqS9vPv7Unj2xW7+5/54f/8GMzu5fcXZcO7ng/8I06JNPDRJd" +
       "zy3dzHZvB37gu7k/Zn7LL/7o/ZubqfM3P9X5ts9//R/+vf/gc5/8pb902+fb" +
       "ntHnYEWuXb9h/7T1Df/zt+Of3bzrgsZ7irwKL6LwJsqvu3q8g7zWF5Msfsuj" +
       "GS/AVx8Cf0n85dMP/Vn3N+7fvI+5edHOkyadpOojdp4WYeKWlJu5pVm7DnPz" +
       "Xjdz8CucuXlpqnNh5t62Hjyvcmvm5t3JtenF/Po9scibpriw6N1TPcy8/GG9" +
       "MOvgWu+Lm5ubl6Z089EpvTilH7grlfpGIb7wulK55XaapXqdyO0mdbO6el3J" +
       "wtfrwK3C6nXbrNw3qrpxwqnHJN93XL9W34hC7/WqtK8frx/NaetfnZqK36mJ" +
       "+wtFH+zu3ZuY/e1PK34yaQmdJ45bvmF/pcHIv/ezb/zK/Ueif8eL+uZ9lylf" +
       "vU55c+/edapvuujE7Z5NHI8nTZ6U9QOflb60+4Ef/c53TcJSdO+e+HXp+vLT" +
       "ovtY4ZmpZk4EvGF/6Ef+r3/0c3/sy/ljIa5vXn6Lbr115EU3vvNpssrcdp3J" +
       "9jye/rsfmD//xi9++eX7l41+70RObU5CMenvJ59e40068tpDe3NhxX3u5v1e" +
       "XqZmcgE9NBLvq4My7x63XPn9/mv9G35r+rs3pX95SRdxujRcysmo4Hei/OCR" +
       "LNc36aH0zSycZOBrP/xHvvZjP/OFf5MSwU8UXwTiC3Pwc4vV56F1cSsal818" +
       "ioFXU/pFqfhTf+NX/2/o/oXwh1b3Q0+YZ8mtX3tC0y+TfeCq0x95LBty6bpT" +
       "v7/1k8c/+hO/+SPffxWMqcenn7Xgy5f8whZzYkde/id/6fy//vr/9tN/7f5j" +
       "YapvXiwaKwntK+bfPk30mcdLTUYgmQzRhEn1spKluRN6oWkl7kUw//mHvmv+" +
       "8//Pj3/4VrqSqeV2r8qbz/32Ezxu/z3YzQ/9yu/7x5+8TnPPvhxCj9nxuNut" +
       "ZfvGxzOjZWkOFzz6P/Brn/gT/4P5pyYbOdmlKhzdq6m5d6crF6Q+Wt98w7RL" +
       "r16Om1c503KTK7GfuwJ/7zWfXUToOuTmCgMv2bf1V9g3X9s/UL3V+G8vp+hj" +
       "jTCAr/7Jj+Pf+xtXWh5rxGWOj/dvNRWq+YSyLv5s+g/vf+eLf/H+zUvGzYev" +
       "B7iZ1aqZNJfNNqYjuMLvGrmbD74J/ubj9PbseO2Rxn/709r4xLJP6+JjEzXV" +
       "L70v9ZeeVL87+33zXVN6z5R+6a788xfoh4tL/pH+3s21sroO+Y5r/p2X7Lse" +
       "itxLRRm2k37eylx980Id1on7cK8+fN3l62bd+ga3OnXJF2/G4vNTeu+U/u5d" +
       "+deegcX3vg0Wl+oXHiLwweJiiFFrMoWmfRXk73nbRb84pfdPE4B35QvPWBT/" +
       "ehZ9yWwm16isqre6IlfpvvUW/t+v/vpv/NoHP/GzVzP7bmuyTddNedqHe6uL" +
       "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" +
       "rdIbCdJdcuHGGuXAqCtSIjds140GKAEq");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "lx/j9BQlD6b0iWmR8q780juj5DLk9btSfXtKnkTvv3wO7C9csj9X37zHd2v5" +
       "8pDgSvaz8P70lD41LfoLd+V/9s7wvgz503fln/z68P5vngP7hUv2X00sn/B+" +
       "09ODZ6G+vrk+unj3p27Ld/2Dd4b6Zcjfvyt/8+tD/b97Duy/v2S/WN+874L6" +
       "4/h65lmYf/42vftX78qvvjPML0P+3F35M2+P+b3Hzk50nfVXnoP+/3jJfrm+" +
       "edGd7FhSPStw+SUrzxPXzJ5F0XxK9M3Nex7cli/9s3dG0WXIP70r//7bU3T/" +
       "sYP4+YdG65sfGa0nj+Trmn/9OfT+zUv2a4/ovXz91WcR9sqUjhNhv3VXfu2d" +
       "EXYZ8r/flX/z69qqv3Gd9WvPQf3vXLK/9duj/vLN1fS/t7krX39nqF+GfP9d" +
       "qXx9+vEbz4FdVez/mExSMDkAeO5cTZL2LLx/75TCqf61u/KX3xnelyF/8a78" +
       "b78+vP/Bc2D/6JL93QnvOn/89Oppe3R573XzkZu3OCY/92+pY9LmoXP1P8Is" +
       "rF/57IMffPD9X5IefHnyOp5m8G/nfF2g/6wonsPAf/n2sHvX4f9kYu5DXJ75" +
       "YOKC7VMMvyL0ibcw/N7P/1vG8NuHKw9u35M+uDOgV84/fK2Te698//UZ1dfh" +
       "LT5x7/3cg7tBZms+PerWdbsdln9pO21v6D14JX8QPlrywdWbuez7tfLAfvDF" +
       "B6/ctuWvPbh9MPTgze9DlcubqWqS/8St8+yVz746WZ9JmJKJdXL+iv3q21/R" +
       "P/cU6p997ct3K3iT+XJfe1rsnvmDwGcuWXH3IvftT4VHh9299z9H7D54yV64" +
       "fQL7xEa8xZI+fEj9sYcC9rDhAv3E7wTW3/QcrL/lkn3o8kPLhdVmVT/B78eI" +
       "PIX6N/1roS49E/UnkfrEc2AXA3LvY3f3mMktetufHX43EP/Mc2CvXLJP1Tef" +
       "fBrxZ9z6fzdwB54Du/zmdu+7734zexL3py7evxt4r58Du/zidw96Bs+fce/t" +
       "65sXrmJ/eQH/sbf8n5nb/4Zi/+xPfeg93/pTyl+/fSb88D+WvMjdvMdrkuTJ" +
       "d91P1F8sStcLr5S8ePvK+0r9ve+dzqGLul3q31fcKuy/AjqozZ7pRgAA");
}
