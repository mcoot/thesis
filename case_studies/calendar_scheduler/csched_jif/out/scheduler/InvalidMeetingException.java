package scheduler;

public class InvalidMeetingException extends Exception {
    
    public InvalidMeetingException scheduler$InvalidMeetingException$() {
        this.jif$init();
        {  }
        return this;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501105429060L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAMVYa2xUxxUeL36wjoWNg40JxhhjUvHobqAEFAwFvLZjuwte" +
       "+dEGx7C5njtrX3P33puZWXuBUJFKKWmj+kcLhEjBSiXyo6/QRolStUkaVVVD" +
       "m7Rq2qhJU5HkZ6qWtPCjFWrzODNzX3vXbn/W0s69d+acM+f5zRl//zqqYhSt" +
       "mzFyCX7CISwxaOQyGmVEz9jmiVGYyuJb335dv3jEeS+GqsfRcoONWUzLkTSK" +
       "awU+bVODn+CoIT2jzWrJAjfMZNpgvCuNbsO2xTjVDIuzB9GXUUUaNRgwo1nc" +
       "0DjR+6id52hD2oGNpkybJ0mRJx2NavmkVCWZSZkaYyCpWs56QpY71J41dEI5" +
       "Wp8GxV1qU5skZjLjrqXFV1eRonZPvGufMk5KVtad35o89/ixhmeXofpxVG9Y" +
       "I1zjBk7ZFgd9xlFdnuQnCWUHdZ3o42ilRYg+QqihmcZJILStcdTIjClL4wVK" +
       "2DBhtjkrCBtZwQEVxZ7eZBrVKZcUMLepZ051ziCm7n1V5UxtinHUHLhFmdcn" +
       "5sEXteBOQnMaJh5L5XHD0oUvIhy+jZ1fAAJgrckTiJe/VaWlwQRqVJEzNWsq" +
       "OcKpYU0BaZVd4MLBdywptEsEQsPHtSmS5aglSpdRS0AVl44QLBw1RcmkJIjS" +
       "HZEoheJz/fDe+VNWvxWTOusEm0L/5cDUFmEaJjlCiYWJYqzbkr6gNb/0aAwh" +
       "IG6KECuaFx66cWBb2ytXFc3aRWiGJmcI5ll8eXLFG62pzfcsUyloM0MEv8Ry" +
       "mfwZd6Wr6EBhNfsSxWLCW3xl+JdHznyX/DWGagdQNbbNQh7yaCW2845hEnov" +
       "sQgVJTKA4sTSU3J9ANXAe9qwiJodyuUY4QOo0pRT1bb8BhflQIRwUQ28G1bO" +
       "9t4djU/L96KDEKqBH+qE3zL47XGf6zia7dkzMcYI7QMpbKLHxoU8gQKeGLOM" +
       "CT5NmMEmsMZIlvGCbhDxYYIyGs0yPE30Amg/geVrFkpzglE8ESwMWLNQNvoh" +
       "QjikWW8RE0d4IwGUzv9t56LwScNcRQWEqzUKFibUWb9tAqBk8blCd++NZ7Kv" +
       "xfzicb0JIObvlFhiJ1RRIXdYJYpNJQOE8jiAAoBl3eaRo4MPPNoBISg6c5UQ" +
       "CEHaUQLKqQA5BiSIYkjfP+x3Hpi/e+3eGKoaB3BlPSSnFUyeSXXbBQtAaJU/" +
       "NUwAnyyJiosic42DJQ9Hq8swVWEpsNFAiGBbCyXTGS3cxdSsP/vBP69cOG0H" +
       "JcxRZxmylHMKZOiIhoTaGFxNSSB+S7v2fPal050xVAlwA7ZxsEygV1t0jxKE" +
       "6PLQVthSBeblbJrXTLHkeaWWT1N7LpiRubJCDI0qbUREIwpKoN434lx6+7d/" +
       "+VwMxQJMrw+dkSOEd4VwRAirl4ixMkiQUUoI0F27mPnW+etn75fZARQbF9uw" +
       "U4wpwA84KcGDj1x98E/vvXv5zViQURyO0cKkaeCitGXlJ/BXAb+PxU+AgZgQ" +
       "TzgSUi4QtftI5Iid7wx0A0wyARdBddY5ZuVt3cgZ2qRJRDr/p37T9uf/Nt+g" +
       "wm3CjHIeRdv+t4Bgfk03OvPasX+1STEVWJyJgf8CMgW0tweSD1KqnRB6FB/+" +
       "/bonXtUuAWQDTDLjJJHIh6Q/kAzgXdIXW+WYjKztEEM7VG10EbZbG9SmrBFo" +
       "KwzVc2Rx882OpNPX876MfS2kYw5aKQNDk9RaVlopf1XUlzjapzzidWXEA8Gy" +
       "qIzVUR3c/SuPtus32zvul+Vwm04YpobjJRkcBLXMyDsmuJvosoqhBeH2ILjP" +
       "76eoZjEToq4qf1Qu9hYdKk7zWY3KOEmvdBRFwvpqZESblsW7HztL7Y1f3xVz" +
       "HblCJRy4bjdyB3HYHPKeYvV2R4yritBJ6gqx2h3cbnpQs0fkvdzI0y3weKBf" +
       "Fl9qevzFxu9986A6z9eXcpRR770r9dXszh/9RlaJyKK2qEuHiQbYr3yexTcX" +
       "3iHDd9/6UFW1PWdFe1AH2idsOJroQ9030b5SKUXYcRC0ainLHVf8rm88deX6" +
       "u5kDMuFDURJNRlmf66aBD0jqtaf03PD1SYzajq9SFh9r/t3W1hePfC3spghD" +
       "iHr+O0/W/H3braek2X6ubIzkis/wX/NFjPcofSWglAQorGQ4Tqubrr15dbb/" +
       "Q6VuNA8W49i/Y9XLH7SsOeVGVmzY6+4qHgOLBvtLcJUJgt2eSP/8ZzXDvw4F" +
       "W0YQXDAnCVU8xdgdBGAIBG9azJ/dNud2PuTVfRvfmen66I3nvCrp872yudTA" +
       "CGfYzOotP10z/+czQ56MQWVqJmTqsJra6RRlhX1Rfu1TkwccyXWfYnJKGCKf" +
       "hxXpUeVKx3dj6ad6tng4KT42iGGTjwDyr9qt/Fb32RxCgFIJcDVd6mYgbzWX" +
       "v3JuQR96ervKjMbSbrvXKuR/8MePXk9cfP9XizRtcW47nzXJLDFL9oQOaIke" +
       "TiRNS9l1Ul2B8DML9ctXL4y9JVHXv6bE4YzPFUzT3zishLjYUpIzpGfjqpSV" +
       "m+FeHPdbSjFhKU83cfegE7e1hK9YEZX7ffEzjbGScwP6ykMFdc3O4n/s2N7z" +
       "8tU7X3WrzDcUrsEJeQF3mQKOKwuDh0/d2PW0KhFsaidPyrsZtJOql2Lewb9h" +
       "SWmerOr+zf9e8cP4Jv/QCHdZZdaFEmR9GZyG/wWQxcfR6cd+cbbxYVByHMUN" +
       "NkoLjIvLeBx7qVQKsKLZ9m+5UoHdbvE8BNt9Joo+oc3CpVkx88RQuuaT+zx7" +
       "Pi89H2n++zU2DR3e2+Zb4+evbWlTng91gO76T3oeOX/hxy/sVPeDOjC8Yf8B" +
       "VUrFCumhTwHK5eOlyBEAAA==");
    
    public InvalidMeetingException() { super(); }
    
    public void jif$invokeDefConstructor() {
        this.scheduler$InvalidMeetingException$();
    }
    
    private void jif$init() {  }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501105429060L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAMU5W8zk1lneP3vLpd1sSi5NN+km+RslmXY9M56bsw0wnvFc" +
       "PJ6L7fFlJpsuvhyP7fFtfB+XoBQJElEpINiUItE8BQmq0EpIFQ+oUl+AVq2Q" +
       "QIiLELQPSIBKHvoAvADF9vy3/Te7eWQkHx+f853vfOe7ne/75v0PoHO+B111" +
       "HXO7Mp3gWrB1gX9tJno+UDqm6PvzbOCm/E4JvvXbX3j4j+6DLi2hS7rNBGKg" +
       "yx3HDkASLKGHLGBJwPPbigKUJXTZBkBhgKeLpp5mgI69hB7x9ZUtBqEHfBr4" +
       "jhnlgI/4oQu8Ys/DQRJ6SHZsP/BCOXA8P4AeJg0xEuEw0E2Y1P3gOgmdV3Vg" +
       "Kv4G+iXoDAmdU01xlQE+Rh6eAi4wwr18PAN/QM/I9FRRBodLzq51WwmgT59e" +
       "cXTi/VEGkC29YIFAc462OmuL2QD0yI4kU7RXMBN4ur3KQM85YbZLAD15V6QZ" +
       "0EVXlNfiCtwMoCdOw812UxnU/QVb8iUB9OhpsAJT4kFPnpLZCWl9MPn821+0" +
       "B/ZeQbMCZDOn/1y26OlTi2igAg/YMtgtfOgl8iviY99+aw+CMuBHTwHvYP74" +
       "F3/y8599+jvf3cF86kNgppIB5OCm/J708b+80nkRvS8n46Lr+HquCredvJDq" +
       "7GDmeuJmuvjYEcZ88trh5HfoP1u88XXw4z3ogSF0XnbM0Mq06rLsWK5uAq8P" +
       "bOCJAVCG0P3AVjrF/BC6kPVJ3Qa70amq+iAYQmfNYui8U3xnLFIzFDmLzmZ9" +
       "3Vadw74rBlrRT1wIgi5kD7SfPfdlz8sH76cCKOq+fIP1gdfLsPg3uo4cWsAO" +
       "/Busrd8INODr/g1Z9MFNPwgVHeQfZkaM6N30ZQ0oYUb9Dbno3jR09YbvyTeO" +
       "J4Z2lBmRMgYgyNQMT2Tg5ty4lkG6/287JzlPPhafOZOJ68pp12FmdjZwTAV4" +
       "N+VbIYb/5Bs3v793ZDwH3AygZ452unaXnaAzZ4odfiY3tp0yZKJcZy4i8wIP" +
       "vci8RvzCW89mIkjc+GwmiBx0/7RNHHuSYdYTM0W/KV9681//85tfed05to4A" +
       "2r/DaO9cmRvds6dP6zlydgoPHKN/6ar4rZvffn1/L9eg+zNfFoiZtmWO4enT" +
       "e9xmfNcPHVnOoT0SelB1PEs086lD7/NAoHlOfDxSiOHBov/xn2a/M9nzv/mT" +
       "62k+kL8zb9U5sJGrR0biujsR5tw9daLCab7CuF/7u7/4N2Qvp+TQv1464YgZ" +
       "EFw/YdM5socK6718LKy5B0AG949fnf3WOx+8+WohqQziuQ/bcD9vczrFjD7H" +
       "+5Xvbv7+h//03l/vHUs3gM67oWTqckH5lQzR88dbZeZuZi4no8TfZ23LUXRV" +
       "FyUT5Jry35c+U/nWv7/98E7cZjayY54HffajERyPfxKD3vj+F/7r6QLNGTm/" +
       "bo7ZcQy282GfOMbc9jxxm9ORfOmvnvqdPxe/lnnDzAP5egoKpwIVx4OKU5UK" +
       "WT5ftC+dmvtc3nwqKeYeLcbv8+/05738YjzWxSX8/u8+2fnZHxdEH+tijuPJ" +
       "5E7b5cQTZlL9uvUfe8+e/9M96MISeri4k0U74EQzzKW6zG5Vv3MwSEIfu23+" +
       "9htydx1cP7K1K6ft4MS2p63g2Gdk/Rw671/YKX6hB8mZTDPOIddq15D8GykW" +
       "Pl20z+TN/o5VefczmQr5RdySrVB1WzR3qhRAjxumvH9oJVwWx2SC3M/8XIHm" +
       "kSwEKcSZH+ba7rrfGU/ewodUZML4+DEY6WQxwZf/+Td+8OvP/TBjPgGdi3LG" +
       "ZDw/gWsS5kHTr77/zlMP3vrRlwtdzxT9tTf+4clujvXzeVPPAoqcOsYJPRmQ" +
       "oh+MC+UESkHgnRow83Qrs8no4EYHb936tZ9ee/vW3omw57k7Io+Ta3ahT8Ga" +
       "B3aHy3Z55l67FCt6//LN1//k919/cxcWPHL7JY7bofWHf/M/P7j21R9970Pu" +
       "grOm86E8DR68Mqj5w/bhb8wtxGrCJgkLSKQRGw4/WdXKRKJpBhsNHGnTxnvt" +
       "uBeRSyOMA1BS8H7S7NRtI/AEZIYgbrjkhRBjid5oxFtGaS2TGm5gjC5snQZM" +
       "0Y7JBOxa5DiuazXpTXWjEWx9sF42Nnww6xg93kun3UkqIJEg2TBf9huoUhLl" +
       "cUmtp7QJw+lms9CYwEp7247Q7AyZOBGn1LZvcXiKGpbO9RfbkJAQpK5EiIED" +
       "ptTf+CotO9MJz6bkes6MxJgtSdy0a5c6znBeNVLeI9qGOl5O3FXUCSeSP60m" +
       "c4PrDsMUQ/sCy7LihF7FTsWWy12DLjV0pV7VulWnP3HXW4koWzSRVCdiZK25" +
       "Dr9klmtxse24vF9vUO6iWSFqFQUf1nm31U+4yoat++ulQRreRuhxFUBnofss" +
       "6ofqeF0fcYGoIHWnhcJ6ollAcFQ34froYlhJDWzdXPZWCpqYPcUOKbvDswNl" +
       "iTi1qm7Si1WJ2uiaJS+JIckEsjIfGh2TrMXcqNrFtMBYex0sWMYUziXLJlhi" +
       "HjdayuyYBO6yXK+kesdq2hWuziZZgDBgB6TWsxTZrvu4EABsStljkdDqZF0Y" +
       "dMsOGw21bclYVtR2m1h58nquEyDzMbwZU/SGI/B0wvubqTxyF2wZE5ecUhuT" +
       "mLKN3QD3ccqfDQLGYuriymRchWbKbc6s1SgSiyu0bK2JocEMlrijASKF1S4o" +
       "cRM+Svj5NPRxq0zCdbnL9ixcJAyzoy94YrFJpbXXWE0kuCy2Y23Yb4zwTij2" +
       "kkZD5jGpug2EnoyINK/3CUse1k2zBQSy129U3VSVfXZrOuPyGI9a9NZS46XS" +
       "4L0GjmkT1WcSnuzwSGKWCGWQ2lsB7vJ9caVQE0maUFpzK3b4aqtW13DbiXxq" +
       "xRHzUbvmzxkWIdD2RGgDdBPrhKNsQ3ZRo6ZO2aXnFUlqYZpqUkM6Zqlqq1+R" +
       "pmhQUwwWJtHGqIuPNtigtMGRlKw1hb7aSHWxqazTsbwYNqmxK43IQeKwrRU1" +
       "An1yOu7M6xNrjFv+eDk0o35H0rrJYjHc9v3ydoYj5ba1gleA83prN12ZeAtn" +
       "4jFPTqhJ5GiUoa95vkXjZaU2jPtsGqFBvUHGjDyRaYrHNyk76ukSy0to0N5g" +
       "65ZkdpRSabJsjqJETXVZKhPDqRSZPU0nKjQ9FJQFsXAnBDXFW4bebjuYiQCR" +
       "dmrj2WziYENm1ZDrLNXBByJLkaMN1a5jOjNcrA11VkqQgavDoISA/sgRMQQz" +
       "Zwxj99gtYARBwqigLRIsPGHjtr3dEnoWGcm1apeg0MGm5cccj7v+pNfW+5jU" +
       "2QrzPoPIicL4MzjCZg1UnvbLA0JO6GVibc3BeLSc6kPNmYv9XjJhGKzENKOq" +
       "OhPNcr2ccG0zbjeXiY9vV1wlKBvJCG/MSIoLNAYDkikRnjAnB2sg8vy8MmmS" +
       "rk6HEtHpDssbiaXxYeyOnEkNqZlJo9RU4BIXjxOKGHtxSVkzU1ypcTHd1j2z" +
       "pifjtU6xrDMs96pNa2bzJRDYzbq6bNOU1EPDmK3Fbtxu1UZyv2tUErSFw1Ek" +
       "RPWUy9bR22lZHq1F0NGDvmASMCa0pdIsYUvt1XJFzdMVw+o1KlCDYX2oK804" +
       "KbfL8bZNK5iiLOrLkAsQebWsbmiC7nqwizTnaKjCk6C0ii2kYwyGgFaiUlDD" +
       "Vuq6jEyjmegLpQozxzme2BIrtdUZr/hyEAOmWxltbBpr9DC4BEuOLQRs2Oap" +
       "7rxLGgQxGGoNCl6305WgDAW+xC+MURrg+LjJ9StlXFpKfZSxPKznjOKUk6t0" +
       "0mpVp+5kJrSajbHKVNeLuC6OqEl3jdIiZzquWhFYMzVEN011hRfwdqu/3QxT" +
       "jqURGWbCWRD6SDWNQjNjvlWuLVxHMgh6LWOkMN52fSskIsd3NhoGBtUhacya" +
       "DeAsDXzubGobtUKFqLZQRutmyi+Q0RS3IgWje3HkbpY4I5k+3xykAdlcVFQk" +
       "4dJBZhcEva1JhrLFkMFiMBuBRcRV6drW0wOMaKw2SVVDZMl2Kb+sriMlHZa3" +
       "SAxGmNoz0Q2I0l4Somir0W6kKBBkl6abzbKHKoKfajBKmyKxHY2qGzwc6JS0" +
       "8JAtSOaygOiDroLCDbbHV2a80gOV9qCqK/6U8BwKLSNlqc6MWGEh051yFpeS" +
       "A05teVarpQChEdbX3XHY67I0MaFNS200RKxbNjaBqJaRWbfCLFLR2KBMT0M9" +
       "OED4igZmagfx3ZXW1QdeaVqGeXiASJ4I1tUMnTRM17oPxwI86Rkz2VEZfmW2" +
       "KcfrU7X5JpQ8r1JXJAmmGlw4abf4GqrDC1QgB03GnwKuz1npolGqbQarKYlF" +
       "ASkTLLEKqoCZwa1lKnSjuNbjywtK6LbtDse2EmWlYP32EOujYkrAyiRUqrNw" +
       "zql0pGY5eqMxROyo47mtZnUbKvN2p68u0qkTzCrlFC7JKVVvjCme2xDWfOMT" +
       "ntigaVMTKrQaVubrWJa3Aq8ubGLU74xULRFcFnCjBFGMhqg0AntVG82zm7ff" +
       "nxtxd+uhmwDuSUimtp1Vb0jIXU5pWIuVlPJChBAhRaMN4EUjYywxkhcJo5CG" +
       "W2MwE9aorM5QQU/pQOZrTTsVCLLbI1GHmorDNZjr9IRBzQprVrFWd0yiciCQ" +
       "tS1KcAMhakh4bZHOemw6R1Ld10hjwbrD1O2rxsZlOKvUA4OZIjFGTxuxLURW" +
       "wQpvgoo2Qhf4UmiqKp4aUp+R41ljux73FBmZ1mzYr06aaStgmwKSBWNdmfV8" +
       "nABUD7Go0XQUh12tDGeM5ssjreeLujLbev4yIKYbs0qCWEI1hreAN/VKqYqC" +
       "ljyrERFMdbJIZamIPdyi0f5y24djnkpklW7ISkmWpGTBYdvBmJ1M1g5pDCMS" +
       "YElzw1Ejf0QuUatUZ52BIkV4C5sEKOE4JUdGOi63znwETYWhOC+lSXOmt9BB" +
       "1S6VUrbapRFQLS2lWglEEm/O7RVaWU2bjTnigKkAa8kW9rkZ6E6NTmuhtjCO" +
       "9Xqd0NLm8WBUB1Nzi+FZMPzKK3mYPDhIEi4XKcxR+TLLDfKJl4ugepc0Pp03" +
       "z+6qBdDB7/xBEevKwfuxfPZhN28vn8g0oTwFeOpu9cYi/H/vl2+9q0x/r7J3" +
       "kK7iAXR/4LifM0EEzFNJ66dPYRoXNdbjzPMPxu9/r/+8/Jt70H1HSeMdpdrb" +
       "F12/PVV8wANB6Nnz2xLGTx6dvQkdNPmZx4fvE2ffVUfy5uo9UnL+HnOLvJkH" +
       "GcMPy1z7dylz7R8nPvQRhUWp8fm87nEgqTO7Wo5/Zy3n5aubUPT1TegE4IVd" +
       "ieRq5OjK1UwH9nU7ctagC9QT9awXXrz6xUDT/WsfTdoLL15//cWjYtG9tOg2" +
       "OvPZ11z3HuwR7zEn582rAfTE3Q5QrGof5Kb5q5ulkPmRTzHxYo7y8p1M/LmP" +
       "YqKnR9ngSS7qQc61q6++xlw9zZDTtYYzAXThAENyO58ufBifjHvy6V5zRRlH" +
       "C6CLhyTm3yAJoMfvIs68MvXEHf/07P6PkL/x7qWLj7/L/m1Rtjz6z+A8CV1U" +
       "Q9M8WYY50T/vekDVC2rO74oyO9ZEmfUfaVc+ELuHtZRPHNc/jghL/g/rnvDO" +
       "hxoAAA==");
}
