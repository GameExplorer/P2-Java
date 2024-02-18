[[DN 5 -  Štetje števk]] 
[[DN 3 - Gesla]]

#tabele  #pretvorba_tipov 

---

Dvojiški zapis znaka je zaporedje osmih enic in ničel, ki predstavljajo dvojiški zapis ASCII kode znaka. Primer: ker je ASCII koda znaka 'A' enaka 65, je dvojiški zapis znaka 'A' enak "01000001".

Dvojiški zapis sporočila je zaporedje dvojiških zapisov znakov, ki sestavljajo sporočilo. Primer: dvojiški zapis sporočila "ABC" je enak "**01000001**01000010**01000011**".

Naloga:  Napiši program DN04, ki v prvem argumentu prejme dvojiški zapis sporočila in na zaslon izpiše originalno sporočilo v ASCII obliki.

**Primer:** ob klicu programa

	  java DN04 **01000001**01000010**01000011**

naj program izpiše

	ABC

Opomba: za "pretvorbo" iz številke v znak uporabite "type-casting", takole:  `char znakA = (char) 65`.


## REŠITEV

```
public class DN4 {  
	public static void main(String[] args) {  
		args = new String[]{"010000010100001001000011"};  
		  
		StringBuilder sb = new StringBuilder();  
		char[] tabela = args[0].toCharArray();  
		  
		for(int i = 1; i <= args[0].length(); i++) {  
			if(i % 8 == 0) {  
				int bin = Integer.parseInt(String.valueOf(sb), 2);  
				char znak = (char) bin;  
				System.out.print(znak);  
				sb = new StringBuilder();  
			}  
			else {  
				sb.append(tabela[i]);  
			}  
		}  
	}  
}
```