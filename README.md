# korean-burger-project


## 📖 Table of Contents

- [Overview](#overview)
- [How It Works](#how-it-works)
- [Business Rules](#business-rules)
- [Usage Examples](#creating-a-order)
- [Future Improvements](#future-improvements)


## overview
This program simulates the operation of a self-service system for a generic hamburger restaurant, using a Korean hamburger chain as a contextual example.
Each basic meal includes a burger (common bread, meat, and cheese), a drink, and a side dish — all in medium size by default. If the user keeps the default sizes, no additional charges apply, and the base price remains as defined in the MealOrder class.

Users can customize their order by:
- **Upgrading the type of meat, which adds an extra fee.**

- **Changing the size of the drink or side, which may also increase the cost.**

This simulator aims to reflect the logic and pricing structure of real-world fast food self-service systems.

## how-it-works
**Item**: 
This class is responsible for centralizing common actions for drinks and sides. It provides the adjusted price considering the size for drinks & side through the getAdjustedPrice() method. It also returns the appropriately formatted name with getName() and displays this formatted information on the console via printItem().

**Burger (Extends Item)**:
This class is responsible for managing the burger, including the creation and storage of extras (toppings). 
- It controls the total price calculation considering the meat type upgrade and the cost of extras, using the overridden getAdjustedPrice() method.
- It instantiates the extras (toppings) within the Burger class, utilizing the static getExtraPrice method from the Extra class to obtain prices, preventing the user from needing to instantiate them manually in the calling code.
- It also overrides the name formatting getName() and detailed item printing printItem() methods. If there are no extras, they are disregarded in the price calculation.

**Extra (Extends Item)**:
This class was created separately to manage extras (toppings), considering that these can vary over time—they might be added, removed, or receive specific promotions. To facilitate future implementations, this responsibility has been isolated within this class. The Extra class inherits from Item and its main method is getExtraPrice(), which uses a switch statement to define the values for each extra.

**MealOrder:**
This class unifies the Burger, Drink, and Side. It creates Burger objects and Item objects for drinks and sides.
In the overall design, the Item class uses the type attribute to indicate the product category, such as:

"DRINK" for beverages , "SIDE" for accompaniments  & "BURGER" for hamburgers. However, in the Burger class, which inherits from Item, the type attribute is reused to represent the type of burger meat—i.e., which "upgrade" was selected. It can take values like:

- **"BASE"** — standard burger (no upgrade) 

- **"BULGOGI"** — upgrade to Bulgogi meat

- **"VEGGIE"** — vegetarian burger
  
This decision was made to simplify the current implementation, but it does lead to a slight overloading of the type attribute's meaning.

**getTotalPrice():** Returns the sum of the burger + extras, drink, and side prices.

**Setters:** These allow changing the burger meat type and the size of the drink and side.

**addBurgerToppings():** This method calls the addToppings method of the Burger class to add extras, creating a higher level of abstraction and keeping the responsibility for extra management within the Burger class.

**printItemizedList():** This shows all information and values to the user.

## business-rules


**Burger Prices:**
- **BASE →** USD 4.00
- **BULGOGI →** +USD 2.00
- **VEGGIE →** +USD 3.00
- **Others →** +USD 0.00 (no extra charge)
  

**Extras (Toppings):**

- **GOCHUJANG MAYO, MOZZARELLA CHEESE →** USD 1.00

- **BACON, GANJANG YANGPA BOKKEUM, KIMCHI →**  USD 1.50

- **OI MUCHIM, YANGSANGCHU →** USD 2.00

- **Others →** USD 0.00 (free or not listed)

**Total burger price →** Base (4.00) + Upgrade (if any) + Extras (if any)


**Drink & Size:**

**Base price (MEDIUM) →** USD 1.00

**Base price (MEDIUM) →** USD 1.50

**SMALL →** -USD 0.50

**LARGE →** +USD 1.00

## creating-a-order

- **Creating a Standard Order:**



You can start by making an order with the meat type as BASE, or any name you prefer, since the meat type will only truly change by using the setter.
Don't add any extras to the hamburger for this first test.
Next, define the soda and the side, without using the setter to change their size.
Finally, ask to print the order and you will see a standard receipt like this:
```
BASE BURGER:           4,00  
------------------------------  
MEDIUM COKE:           1,00  
MEDIUM ONIONS:         1,50  
------------------------------  
TOTAL PRICE:           6,50
==============================
```



- **To create an order where you only change the drink and/or side size:**

Start by creating a MealOrder with a base burger (which refers to the combination of bread, meat, and cheese). Pass the burger type, drink name, and side to the constructor. Then, call **order1.setDrinkSize("LARGE");** to update the drink size, and finally print the order.
The output will look like this:

```
BASE BURGER:           4,00
------------------------------
LARGE COKE:            2,00
MEDIUM ONIONS:         1,50
------------------------------
TOTAL PRICE:  7,50
==============================
```



- **To create an order by changing meat type, adding extras, and adjusting the size of sides and/or drinks:**
```
order2.setMeatType("BULGOGI");
order2.addBurguerToppings("KIMCHI", "MOZZARELLA CHEESE", "GOCHUJANG MAYO");
order2.setDrinkSize("LARGE");
order2.setSideSize("SMALL");
```
  _The result will look something like this:_
```
BASE BURGER:           4,00
+ BULGOGI UPGRADE:     2,00
------------------------------
KIMCHI:                1,50
MOZZARELLA CHEESE:     1,00
GOCHUJANG MAYO:        1,00
LARGE COKE:            2,00
SMALL FRIES:           1,00
------------------------------
TOTAL PRICE:          12,50
==============================
```


## future-improvements


- **Refactor MealOrder ->** separate type and name responsibilities for the burger. The user will select "BURGER" as the item type, and meatType will define the kind of meat (e.g., BULGOGI, VEGGIE).

- **Display free items clearly ->** whenever an item costs 0.00, show "FREE OF CHARGE" to make it clear that it's free and avoid confusion.

- **Add user interaction ->** create a user-friendly interface that allows customers to build their own order step by step.

- **Frontend design ->** develop a visual interface inspired by global fast-food chains, simulating a digital self-service system.




