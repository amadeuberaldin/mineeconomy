# MineEconomy

MineEconomy is a simple server-side Fabric economy mod for the MundoZ Minecraft server.

It adds a global emerald-based shop through the `/shop` command.

The project intentionally avoids virtual money, bank accounts, balances, inflation systems, and complex economy mechanics.

Instead, it keeps the economy close to vanilla Minecraft by using emeralds as the physical currency.

## Concept

MineEconomy was created to provide a controlled global shop without turning the server into a complex economy network.

The design is simple:

- Emeralds are the currency
- Prices are fixed
- The shop is global
- Players use `/shop`
- No virtual wallet is required

This keeps the economy understandable for players and easy to balance for the server owner.

## Command

### `/shop`

Opens the global shop.

The shop appears as a virtual merchant screen named:

- `Loja Global`

## Main Features

- Global emerald shop
- Virtual merchant interface
- Fixed prices
- Enchanted book sales
- Utility item sales
- Cosmetic music disc sales
- Safezone manual sale
- No external database
- No virtual balance system

## Currency

MineEconomy uses emeralds as the server currency.

This keeps the economy close to vanilla gameplay.

Players can obtain emeralds naturally through:

- villagers
- mining
- server rewards
- MundoZ/HiveMind gameplay rewards

## Shop Categories

### Manuals

- Safezone manual

### Mining Enchantments

Examples:

- Efficiency V
- Fortune III
- Silk Touch
- Unbreaking III
- Mending

### Combat Enchantments

Examples:

- Sharpness V
- Smite V
- Looting III
- Fire Aspect II
- Knockback II
- Sweeping Edge III

### Armor Enchantments

Examples:

- Protection IV
- Fire Protection IV
- Blast Protection IV
- Projectile Protection IV
- Feather Falling IV
- Respiration III
- Aqua Affinity
- Thorns III
- Depth Strider III
- Frost Walker II

### Bow and Crossbow Enchantments

Examples:

- Power V
- Punch II
- Flame
- Infinity
- Multishot
- Quick Charge III
- Piercing IV

### Fishing Enchantments

Examples:

- Luck of the Sea III
- Lure III

### Trident Enchantments

Examples:

- Loyalty III
- Impaling V
- Riptide III
- Channeling

### Mace Enchantments

Examples:

- Density V
- Breach IV
- Lunge III

### Utility Items

Examples:

- Golden Apple
- Golden Carrots

### Cosmetic Items

Music discs are sold as low-cost cosmetic items.

Examples:

- 13
- cat
- blocks
- chirp
- far
- mall
- mellohi
- stal
- strad
- ward
- 11
- wait
- pigstep
- otherside
- relic

## Price Philosophy

Prices are manually balanced around emeralds.

The goal is not to create a fully automated market.

The goal is to provide useful items at predictable prices while keeping survival progression meaningful.

Powerful enchantments are more expensive.

Cosmetic items are intentionally cheap.

## Technical Architecture

Main classes:

- `MineEconomyMod`
- `MerchantShopCommands`
- `EmeraldShopOffers`
- `ShopEntry`
- `VirtualMerchant`
- `SafeMerchantMenu`
- `ItemRewardFactory`

## Technical Details

- Minecraft version: 26.x
- Fabric mod
- Server-side economy/shop system
- Uses Fabric command registration
- Uses vanilla-style merchant trading interface
- No database required

## Design Philosophy

MineEconomy exists to support the MundoZ server without overwhelming it.

The project prioritizes:

- simplicity
- vanilla-friendly currency
- predictable prices
- easy balancing
- no unnecessary economy complexity

## Known Limitations

- Prices are hardcoded.
- There is no player-to-player market.
- There is no virtual balance.
- There is no web dashboard.
- The shop is designed specifically for MundoZ server rules.

## Future Improvements

Possible future improvements:

- Configurable prices
- Configurable shop entries
- Admin reload command
- Better category organization
- Optional shop pages
- More utility items
- Better documentation of exact prices

## License

All Rights Reserved.
