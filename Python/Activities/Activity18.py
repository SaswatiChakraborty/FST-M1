# Import pandas as pd
import pandas
import pandas as pd

# Create a Dictionary that will hold our data
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}
df = pd.DataFrame(data)
df.to_csv("../Inputs/credentials.csv", index=False)


dataframe = pd.read_csv("../Inputs/credentials.csv")
# Print the full data
print(dataframe)

# Print usernames
print(dataframe["Usernames"])

#Print username and pwd for 2nd row
print(dataframe["Usernames"][1], dataframe["Passwords"][1])

# Sort the Usernames column data in ascending order
print("Usernames sorted in ascending order:")
print(dataframe.sort_values('Usernames'))

# Sort the Passwords column in descending order
print("Passwords sorted in descending order:")
print(dataframe.sort_values('Passwords', ascending=False))