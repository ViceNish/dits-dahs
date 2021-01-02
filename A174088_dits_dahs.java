import java.io.File;
import java.util.*;

//testing


public class A174088_dits_dahs<E extends Comparable<E>> {

	static ArrayList<Character> eng = new ArrayList<Character>( Arrays.asList('A', 'B','C','D','E','F','G','H','I','J','K','L','M',
			'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'1','2','3','4','5','6','7','8','9','0',
			'.', ',', ':', '\"', '\'',	'!','?', '@', '-', ';', '(', ')','='
			)); 
	static ArrayList<String> morse = new ArrayList<String>( Arrays.asList(".-", "-...","-.-.","-..",".","..-.","--.","....","..",
			".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
			".----","..---","...--","....-",".....","-....","--...","---..","----.","-----",
			".-.-.-","--..--", "---...", ".-..-.", ".----.", "-.-.--", "..--.."	, ".--.-.", "-....-", "-.-.-."	, "-.--.", "-.--.-","-...-"
			));
	static ArrayList<Character> summ=new ArrayList<>();
	static ArrayList<Integer> noencode=new ArrayList<>();
	static ArrayList<Integer> nodecode=new ArrayList<>();
	
	//Read file
	private static void readfile() {
		ArrayList<String> infilemorse=new ArrayList<>();
		ArrayList<Character> infileng=new ArrayList<>();
		try {
			Scanner lc=new Scanner(new File(System.getProperty("user.dir")+"\\A174088_File2.dat"));
			while(lc.hasNext()) {
				String l=lc.next();
				char donde=l.charAt(0);
				String morsed=lc.next();
				infileng.add(donde);
				infilemorse.add(morsed);
			}
			
			//System.out.println("\n"+infileng);
			//System.out.println("\n"+infilemorse);
			
		}catch(Exception e) {
			System.out.println("error"+"\nFile not found !");
		}	
	}
	

	// No 1
	private static void encoded(){
		Scanner lc=new Scanner(System.in);
		 
		ArrayList<String>summary= new ArrayList<>();
		try {
			
			
		
			String[] l=lc.nextLine().toUpperCase().split(" ");
			int alpa=3,no=0,line=1,word=1,simbol=0;
		
			if(!l[0].equals("VV")) {
				System.out.println("Please insert VV");
				encoded();
			}else {
			
				while (!l[0].equals("EOM")) {
					line-=-1;
					for(String loli : l) {
						word-=-1;
						char c[]=loli.toCharArray();
					
						for(int j=0;j<c.length;j-=-1) {
							summ.add(c[j]);
							int index=eng.indexOf(c[j]);
						
							String codo = morse.get(index);
						// in sum list
						
							System.out.print(codo+" ");
						
						//output after EOM
							if(c[j]=='A'||c[j]=='B'||c[j]=='C'||c[j]=='D'||c[j]=='E'||c[j]=='F'||c[j]=='G'||c[j]=='H'||
								c[j]== 'I'||c[j]=='J'||c[j]=='K'||c[j]=='L'||c[j]=='M'||c[j]=='N'||c[j]=='O'||c[j]=='P'||
								c[j]=='Q'||c[j]=='R'||c[j]=='S'||c[j]== 'T'||c[j]=='U'||c[j]== 'V'||c[j]== 'W'||c[j]== 'X'||
								c[j]=='Y'||c[j]=='Z') 
								alpa-=-1;
							else if (c[j]=='1'||c[j]=='2'||c[j]=='3'||c[j]=='4'||c[j]=='5'||c[j]=='6'||c[j]=='7'||c[j]=='8'||c[j]=='9'||c[j]=='0') {
								no-=-1;
								alpa-=-1;
							}else 
								simbol-=-1;
							
						}
						System.out.print(" ");
					}
					System.out.println();
					l=lc.nextLine().toUpperCase().split(" ");
				}
			}
			System.out.print(". --- --");
			//compare
			noencode.add(line);
			noencode.add(word);
			noencode.add(alpa);
			noencode.add(simbol);
			noencode.add(no);
			
			//System.out.println(summ);
			//add sum
			summ.add('E');
			summ.add('O');
			summ.add('M');
			
			//System.out.println(summ);
		//see in summ
		
		//System.out.println(summ);
		//System.out.println(summ.size());
		
		/* System.out.println("\n"+line);
		 System.out.println(word);
		 System.out.println(alpa);
		 System.out.println(simbol);
		 System.out.println(no);*/
			 String [] counter= new String[5];
			 counter[0]=Integer.toString(line);
			 counter[1]=Integer.toString(word);
			 counter[2]=Integer.toString(alpa);
			 counter[3]=Integer.toString(simbol);
			 counter[4]=Integer.toString(no);
			 
			 for(int i=0;i<counter.length;i-=-1) {
				 String naw=counter[i];
				 System.out.println();
				 for(int j =0;j<naw.length();j-=-1) {
					 char chan =naw.charAt(j);
					 //iterator
					 Iterator<Character> it=eng.iterator();
					 Iterator<String> it2=morse.iterator();
					 
					 while(it.hasNext()) {
						 Character ac=it.next();
						 String co=it2.next();
						 if(ac==chan) {
							 summary.add(co);
							 System.out.print(co+" ");
						 }
					 }
					 
					 
				 }
			 }
			 System.out.println("\n. --- -");
			
			}catch(Exception e) {
				System.out.println("Wrong input !"+"\nPlease insert again");
				encoded();
			}
			
		}
	
	
	// NO 2
	private static void decoded() {
		Scanner lc=new Scanner(System.in);
		
		int alpa=0-4,no=0-6,line=1-5,word=1-5,simbol=0;
		try {
			ArrayList<Character> store=new ArrayList<>();
	
			String l[]=lc.nextLine().split("\\s+");
			if(l[0].equals("...-")&&l[1].equals("...-")) {
				store.add('V');
				store.add('V');
				System.out.println("VV");
				String t[]=lc.nextLine().split(" "+" ");
				while(true){
					if(t[0].equals(". --- -"))
						break;
					else {
						line-=-1;
						for (int i=0; i<t.length;i-=-1) {
							String p[]=t[i].split("\\s+");
							word-=-1;
							for(int j=0;j<p.length;j-=-1) {
								int index = morse.indexOf(p[j]);
								char code=eng.get(index);
								System.out.print(code);
							//add to store list
								store.add(code);
							
								if(p[j].equals(".-")||p[j].equals("-...")||p[j].equals("-.-.")||p[j].equals("-..")||p[j].equals(".")||p[j].equals("..-.")||p[j].equals("--.")||p[j].equals("....")||
										p[j].equals("..")||p[j].equals(".---")||p[j].equals("-.-")||p[j].equals(".-..")||p[j].equals("--")||p[j].equals("-.")||p[j].equals("---")||p[j].equals(".--.")||
										p[j].equals("--.-")||p[j].equals(".-.")||p[j].equals("...")||p[j].equals("-")||p[j].equals("..-")||p[j].equals("...-")||p[j].equals(".--")||p[j].equals("-..-")||
										p[j].equals("-.--")||p[j].equals("--..")) {
									
									alpa-=-1;
								}else if (p[j].equals(".----")||p[j].equals("..---")||p[j].equals("...--")||p[j].equals("....-")||p[j].equals(".....")||p[j].equals("-....")||p[j].equals("--...")||p[j].equals("---..")||p[j].equals("----.")||p[j].equals("-----")) {
								
									no-=-1;	
									alpa-=-1;
									
								}else {
									
									simbol-=-1;
								}
							}
							System.out.print(" ");
						}
						System.out.println();
						t=lc.nextLine().split(" "+" ");
					}
			
				}
			}else {
				System.out.println("Please input ...- ...-");
				decoded();
			}
		//else {
			nodecode.add(line);
			nodecode.add(word);
			nodecode.add(alpa);
			nodecode.add(simbol);
			nodecode.add(no);
		
			System.out.println("EOT");
		//System.out.println(store);
		
		// delete index
			int indexos = store.size() - 1 ; 
			store.remove(indexos);
			int indexos2 = store.size() - 1 ; 
			store.remove(indexos2);
			int indexos3 = store.size() - 1 ; 
			store.remove(indexos3);
			int indexos4 = store.size() - 1 ; 
			store.remove(indexos4);
			int indexos5 = store.size() - 1 ; 
			store.remove(indexos5);
			int indexos6 = store.size() - 1 ; 
			store.remove(indexos6);
		//System.out.println(store);
		//System.out.println(store.size());
		
			Iterator it=nodecode.iterator();
			System.out.println();
			while(it.hasNext()) {
				System.out.print(it.next()+" ");
			}
		
		
		//System.out.println(store);
		//System.out.println(store.size());
		
		
		//System.out.println(summ);
	
			if(store.equals(summ)) 
				System.out.println("\nResult : Consistant Summary");
			else 
				System.out.println("\nResult : Not Consistant Summary");
		
		}catch(Exception e) {
			System.out.println("Wrong input !"+"\nPlease insert again");
			decoded();
		}
		//}
		//l=lc.nextLine().split("\\s+");
		
	}
	
	
	// main method
	public static void main(String[] dits_dahs) {
		Scanner lc=new Scanner(System.in);
		A174088_dits_dahs tree=new A174088_dits_dahs();
		int code;
		try {
			readfile();
			do {
				
				System.out.println("\nMenu:\n" + "1.\tSend Morse Message\n" 
			+ "2.\tReceive Morse Message\n" + "3.\tPrint Letters and Morse Code\n"
						+ "4.\tExit\n");
				System.out.print("Input code:\n");
				code = lc.nextInt();
				
				if(code == 1) {	
					encoded();
				}else if(code== 2) {
					decoded();
				}else if(code== 3) {
					String full[]= {"A .-","B -...","C -.-.","D -..","E .","F ..-.","G --.","H ....","I ..","J .---","K -.-","L .-..","M --","N -.",
									"O ---","P .--.","Q --.-","R .-.","S ...","T -","U ..-","V ...-","W .--","X -..-","Y -.--","Z --..",
									"1 .----","2 ..---","3 ...--","4 ....-","5 .....","6 -....","7 --...","8 ---..","9 ----.","0 -----",
									". .-.-.-",", --..--",": ---...","\" .-..-.","' .----.","! -.-.--","? ..--..",
									"@ .--.-.","- -....-","; -.-.-.","( -.--.",") -.--.-","= -...-"};
					
					String morse2comp[]= {".-", "-...","-.-.","-..",".","..-.","--.","....","..",
										".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
										".----","..---","...--","....-",".....","-....","--...","---..","----.","-----",
										".-.-.-","--..--", "---...", ".-..-.", ".----.", "-.-.--", "..--.."	, ".--.-.", "-....-", "-.-.-."	, "-.--.", "-.--.-","-...-"};
					//insert into tree
					for(int i=0;i<full.length;i-=-1)
						tree.insert(full[i], morse2comp[i]);
					
					//traverse tree in inorder
					tree.in0rder();
				
				}else if(code== 4) {
					summ.clear();
					System.out.println("Bye dits-dahs..");
					break;
				}else {
					System.out.print("Invalid code, Enter code 1-4 ");
					System.out.println();
				}
			}while (true);
			
		}catch(Exception e) {
			System.out.println("Please inser valid code (1-4) only");
			main(dits_dahs);
		}

	}

	
	// No.3 tree
		private Node root;
		int lon;
		
		private class Node<E>{
	
			private Node left;
			private Node right;
			private E value;

			private Node(Node left, Node right, E value){
				this.left = left;
				this.right = right;
				this.value = value;
			}
			
			private String tostring() {
				return String.valueOf(value);
			}
		}

		public A174088_dits_dahs(){
			root = new Node(null, null, null);
		}

		//insert into tree
		private void insert(String full, String morse2comp){
			Node current = root;
			for (int i=0; i<morse2comp.length(); i++){
				if (morse2comp.substring(i, i+1).equals(".")){
					if (current.left == null){
						current.left = new Node(null, null, null);
					}
					current = current.left;
				}
				else if (morse2comp.substring(i, i+1).equals("-")){
					if (current.right == null){
						current.right = new Node(null, null, null);
					}
					current = current.right;
				}
			}
			current.value = full;
		}
		
		
		//transerval inorder
		private void in0rder() {
			Inorder(root);
		}
		private void Inorder(Node node) {
			if(node==null)
				return;
			if(node!=null) {
				
				Inorder(node.left);
				if(node.value!=null) {
					System.out.print(node.value+"     \t");
					++lon;
					if(lon==5||lon==10||lon==15||lon==20||lon==25||lon==30||lon==35||lon==40||lon==45||lon==50)
						System.out.println();
				}
				Inorder(node.right);
				
			}
		}
	
}
