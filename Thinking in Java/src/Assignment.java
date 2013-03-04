class Assignment {
	public static void main(String[] args) {
		boolean prime = true;
		int tmp;
		int k=1;
		for (int i = 1; i <= 10000; i++)
		{
			tmp = i/2 + 1;
			for (int j=2; j < tmp; j++)
			{
				if ((i%j)==0)
				{
					prime = false;
					break;
				}
			}
			if (prime)
			{
				System.out.print(i+" ");
				if ((k%20) == 0)
					System.out.println();
				k++;
			}
			else 
				prime = true;
		}
	}
}