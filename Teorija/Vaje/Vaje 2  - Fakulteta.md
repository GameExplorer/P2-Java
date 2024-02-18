
**6.3.2023**

[[Vaje 1 - For Zanka]]
[[Vaje 3 - Pikčasti Znaki]]

#Math #formatiranIzpis 

---

```ìmport java.util.Locale

Locale.setDefaut(Locale.US) -> nastavi na angleščino
```


[Koda](https://github.com/GameExplorer/P2_Vaje/tree/master/src/Vaje02)

## Fakulteta & Stirling

Stirlingova formula je bolj natančna od *n!*. Na začetku je med n! in stirlingom velika relativna napaka, ki pa se ko števila postanejo večja postane manjša.Pri n = 1 je relativna napaka ```7.7862991``` Pri n = 100 je relativna napaka ```0.0832983```. 


## Dodatni izzivi

PI je definirana na 15 decimalk, ker je to največja vrednost tipa double. 

## REŠITEV

```
public class Fakulteta {  
	public static void main(String[] args) {  
		System.out.println(fakultetaL(5));  
		System.out.println(fakultetaD(5));  
		  
		System.out.println(stirlingL(5));  
		System.out.println(stirlingD(5));  
		  
		izpisTabele();  
		izpisTabele100();  
	}  
	  
	public static long fakultetaL(int n) {  
		long i;  
		long rez = 1;  
		for(i = 1; i <= n; i++) {  
		rez *= i;  
		}  
		return rez;  
	}  
	  
	public static double fakultetaD(int n) {  
		int i;  
		double rez = 1;  
		for(i = 1; i <= n; i++) {  
		rez *= i;  
		}  
		return rez;  
	}  
	  
	public static long stirlingL(int n) {  
		return Math.round((Math.sqrt(2 * Math.PI * n)* (Math.pow((n/Math.E), n))));  
	}  
	  
	public static double stirlingD(int n) {  
		return ((Math.sqrt(2 * Math.PI * n)* (Math.pow((n/Math.E), n))));  
	}  
	  
	public static void izpisTabele() {  
		System.out.printf("%3s %15s %22s %17s %n", "n", "n!", "Stirling(n)", "napaka (%)");  
		  
		for(int i = 0; i < 60; i++) {  
		System.out.print("-");  
	}  
	  
	System.out.println();  
		for(int i = 1; i <= 20; i++) {  
			long factorial = fakultetaL(i);  
			long stirling = stirlingL(i);  
			double napaka = (double) (factorial - stirling) / factorial;  
			System.out.printf("%3d %20d %22d %10f %n", i, factorial, stirling, napaka);  
		}  
	}  
	  
	public static void izpisTabele100() {  
		System.out.printf("%3s %15s %22s %17s %n", "n", "n!", "Stirling(n)", "napaka (%)");  
		  
		for(int i = 0; i < 60; i++) {  
			System.out.print("-");  
	}  
	  
	System.out.println();  
			for(int i = 1; i <= 100; i++) {  
				double factorial = fakultetaD(i);  
				double stirling = stirlingD(i);  
				double napaka = (factorial - stirling) / factorial;  
				System.out.printf("%3d %20.9e %18.9e %14f %n", i, factorial, stirling, napaka);  
		}  
	}  
	}
```