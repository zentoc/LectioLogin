# LectioLogin


Lavet med playwright, danner en browser for manuelt login med MitId for derefter at returnere en LectioSession,
som indeholder playwright, browser, browserContext og page objekter,

## Installation

Projektet bruger jitpack for udgivelse og kan importes via maven ved brug af 

```
     <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

```

og 

```

    <dependency>
	    <groupId>com.github.zentoc</groupId>
	    <artifactId>LectioLogin</artifactId>
	    <version>Tag</version>
	</dependency>

```

For flere detaljer hvis du bruger maven findes ved \
https://jitpack.io/#zentoc/LectioLogin/4578f37712 
## Brug 

```

import dk.zentoc.LectioLogin;

public class LectioLoginExample {
    public static void main(String[] args) {
        LectioLogin lectio = new LectioLogin();
        LectioSession lectioSession = lectio.loginLectio(SkoleId);

        lectioSession.page.navigate("https://enhverside.dk");
    }
}

```


Skole id findes i url'en for lectio

https://www.lectio.dk/lectio/123/forside.aspx \
Her er 123 skoleId'et, det ligger altid efter lectio.dk/lectio/skoleId  \
Sessionen kan desuden lukkes ved brug af 


```
lectioSession.close()
```


## Licens

MIT License

Copyright (c) 2025, zentoc

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.



