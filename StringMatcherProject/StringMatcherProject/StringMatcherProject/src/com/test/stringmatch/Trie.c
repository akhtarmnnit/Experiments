/*
Algorithm
1. Use a Trie for fast lookup of the strings in order to find whether the string is for fixed match or exact match. The hash table would have a 
structure containing an id implemented as int and the type of match implemented as bool(0=exact match and 1 = prefix match)
struct val
{
int val;
bool type;
}
we store the values like below:
Key        Value <ID,type>
contactus <1,0>
img		  <1,1>
imghd	  <2,1>
abc		  <908,0>
fas       <907,1>

2. For each incoming input string coming for lookup, traverse the trie to find the match.

Case 1: We reach the data node without exhausting or matching all characters in the input string. In this case we check the type of the data node 
i.e. type = 0(exact match) or type = 1(prefix match). If the type = 1 we return the ID else we return -1.

Case 2: We reach the data node and all the characters from incoming input string is exhausted then we return the ID without looking at type.


By virtue of a trie we always get the longest match in case of prefix match.


MyTrie would look something like this.

						<NULL, A , B, C, D, .......I,.... N, O, P,....,Z>
                                  /    \                         \
					<A,...U,...O,...>   <A,..,R>                 <..,O,A,,,>

<Black> <Bus> <BOX>						 <CAT> <CAR>                     <POST> <PACK>



*/


/* API exposed from C implementation*/
add_string_to_trie(char *s,int id, int type);
delete_string_from_trie(char* s);
search_string_to_trie(char*s);

#define MAX_ALPHABETS 27

typedef enum {value, pointer} trienodetype;

struct trie_node
{
	trienodetype type;
	union
	{
		char *keydata;
		trieptr alpha[MAX_ALPHABETS];
	}u;
	int ID;
	bool match_type;//whether exact or prefix
	int num_occurence;//no of occurence of the word
};
struct trie_node * root;

bool addStringToTrie(trie_node *ptr,char* inputString,int id, int type)
{
	//We have to traverse the tree using code similar to search_for_String_match.
	//If we get a match we just increase count.
	//If we do not get a match we insert it at appropiate place.
}

bool deleteStringFromTrie(trie_node *ptr,char* inputString)
{
	int count=0;
	int check = search_for_String_match(ptr,inputString,0,&count);
	if(check == -1)
	{
		return false;
	}
	else if(count>1)
	{
		//The code here is same as search_for_String_match. On finding the string we just have to decrease the count
	}
	else if(count==1)
	{
		//The code here is same as search_for_String_match. On finding the string we have to ensure that we make the index pointing to the string as NULL.
		//Alternately we can make count =0 to mark it deleted
	}
}

int search_for_String_match(trie_node *ptr,char* inputString,int idx,int *count)
{
	if(ptr==null)
		return -1;
	if(ptr->type == value)
	{
		if(strcmp(t->u.keydata,inputString)!=0) //we have a prefix match here
		{
			if(t->type==1) //expected is also prefix match
			{
				*count = t->num_occurence;
				return t->ID;//Return the ID for prefix match
				
			}
			else
			{
				*count = t->num_occurence;
				return -1;
			}
		}
		else if(strcmp(t->u.keydata,inputString)==0) //we have a exact match here
		{
			*count = t->num_occurence;
			return t->ID;//return the ID without any further checking since exact match is always preferred
		}
	}
	else
	{
		//Keep searching in trie
		return search_for_String_match(t->u.alpha[get_index(keydata,idx)],inputString,idx+1);
	}
}