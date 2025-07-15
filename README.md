# korean-burger-project


## 📖 Table of Contents

- [Overview](#overview)
- [How It Works](#how-it-works)
- [Business Rules](#business-rules)
- [Usage Examples](#creating-a-order)
- [Future Improvements](#future-improvements)


## overview
Self-service simulator for a Korean hamburger restaurant.

This program aims to simulate the operation of a self-service system for a generic hamburger chain. For this context, we've chosen a Korean hamburger chain as an example. The basic order includes a base burger, consisting of common bread, meat, and cheese, along with drinks and sides of medium size. By default, every order comes with a medium-sized drink and side. When the size remains medium, meaning no changes are made by the user, there is no extra charge, and the price remains fixed as defined in the MealOrder class.
It's possible to upgrade the type of meat, which incurs an additional charge. You can also change the size of the drink and side, which may also result in extra costs.

## how-it-works
**Item**: 
This class is responsible for centralizing common actions for drinks and sides. It provides the adjusted price considering the size for drinks & size through the getAdjustedPrice() method. It also returns the appropriately formatted name for drinkns & size with getName() and displays this formatted information on the console via printItem().

**Burger (Extends Item)**:
This class is responsible for managing the burger, including the creation and storage of extras (toppings). It controls the total price calculation considering the meat type upgrade and the cost of extras, using the overridden getAdjustedPrice() method. It instantiates the extras (toppings) within the Burger class, utilizing the static getExtraPrice method from the Extra class to obtain prices, preventing the user from needing to instantiate them manually in the calling code. It also overrides the name formatting (getName()) and detailed item printing (printItem()) methods. If there are no extras, they are disregarded in the price calculation.

**Extra:**
This class was created separately to manage extras (toppings), considering that these can vary over time—they might be added, removed, or receive specific promotions. To facilitate future implementations, this responsibility has been isolated within this class. The Extra class inherits from Item and its main method is getExtraPrice(), which uses a switch statement to define the values for each extra.

**MealOrder:**
This class unifies the Burger, Drink, and Side. It instantiates Burger objects and Item objects for drinks and sides. In the general context of the application, the Item class uses the type attribute to indicate the product's category, such as:
"DRINK" for beverages , "SIDE" for accompaniments  & "BURGER" for hamburgers. **However, in the Burger class, which inherits from Item, the type attribute is reused to represent the type of burger meat—i.e., which "upgrade" was selected. It can take values like:
- "BASE" — standard burger (no upgrade) 

- "BULGOGI" — upgrade to Bulgogi meat

- "VEGGIE" — vegetarian burger
This decision was made to simplify the current implementation, but it does lead to a slight overloading of the type attribute's meaning.**

**getTotalPrice():** Returns the sum of the burger, drink, and side prices.

**Setters:** These allow changing the burger meat type and the size of the drink and side.

**addBurgerToppings():** This method calls the addToppings method of the Burger class to add extras, creating a higher level of abstraction and keeping the responsibility for extra management within the Burger class.

**printItemizedList():** This shows all information and values to the user. If the value is zero, it indicates no charge was incurred.

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
- **To create an order where you change the meat type, add extras to the burger, and alter the size of both the side and the drink:**
```
order2.setMeatType("BULGOGI");
order2.addBurguerToppings("KIMCHI", "MOZZARELLA CHEESE", "GOCHUJANG MAYO");
order2.setDrinkSize("LARGE");
order2.setSideSize("SMALL");
```
The result will look something like this:
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
```


## future-improvements


- **Refactor MealOrder ->** separate type and name responsibilities for the burger. The user will select "BURGER" as the item type, and meatType will define the kind of meat (e.g., BULGOGI, VEGGIE).

- **Display free items clearly ->** whenever an item costs 0.00, show "FREE OF CHARGE" to make it clear that it's free and avoid confusion.

- **Add user interaction ->** create a user-friendly interface that allows customers to build their own order step by step.

- **Frontend design ->** develop a visual interface inspired by global fast-food chains, simulating a digital self-service system.




